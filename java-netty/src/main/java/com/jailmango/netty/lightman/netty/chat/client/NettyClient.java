package com.jailmango.netty.lightman.netty.chat.client;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import com.jailmango.netty.lightman.netty.chat.client.handler.ClientFluxHandler;
import com.jailmango.netty.lightman.netty.chat.client.handler.LoginResponseHandler;
import com.jailmango.netty.lightman.netty.chat.client.handler.MessageResponseHandler;
import com.jailmango.netty.lightman.netty.chat.codec.CustomSpliter;
import com.jailmango.netty.lightman.netty.chat.codec.PacketCodeC;
import com.jailmango.netty.lightman.netty.chat.codec.PacketDecoder;
import com.jailmango.netty.lightman.netty.chat.codec.PacketEncoder;
import com.jailmango.netty.lightman.netty.chat.packet.request.MessageRequestPacket;
import com.jailmango.netty.lightman.netty.chat.util.LoginUtil;

/**
 * NettyClient
 *
 * @author he.gang33
 * @CreateDate 2019-08-08
 * @see com.jailmango.netty.lightman.netty.chat.client
 * @since R9.0
 */
public class NettyClient {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(NettyClient.class);

    /**
     * MAX_RETRY
     */
    private static final int MAX_RETRY = 4;

    /**
     * main
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        logger.info("Netty Client starting...");

        Bootstrap bootstrap = new Bootstrap();
        NioEventLoopGroup group = new NioEventLoopGroup();

        bootstrap.group(group).channel(NioSocketChannel.class).handler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            protected void initChannel(NioSocketChannel ch) throws Exception {
                ch.pipeline().addLast(new ClientFluxHandler());
                // 基于长度域的拆包器
                ch.pipeline().addLast(new CustomSpliter());
                ch.pipeline().addLast(new PacketDecoder());
                ch.pipeline().addLast(new LoginResponseHandler());
                ch.pipeline().addLast(new MessageResponseHandler());
                ch.pipeline().addLast(new PacketEncoder());
            }
        }).option(ChannelOption.SO_KEEPALIVE, true);

        String ip = "127.0.0.1";
        int port = 8080;
        connect(bootstrap, ip, port, MAX_RETRY);

        logger.info("Main Thread end...");
    }

    /**
     * connect
     *
     * @param bootstrap Bootstrap
     * @param ip String
     * @param port int
     * @param retry int
     */
    private static void connect(Bootstrap bootstrap, String ip, int port, int retry) {
        bootstrap.connect(ip, port).addListener(future -> {
            if (future.isSuccess()) {
                logger.info("Netty Client started...");
                startConsoleThread(((ChannelFuture) future).channel());
            }
            else {
                if (0 == retry) {
                    logger.info("Netty Client shutdown...");
                    bootstrap.config().group().shutdownGracefully();
                }
                else {
                    logger.info("Retry...");
                    int order = MAX_RETRY - retry + 1;
                    int delay = 1 << order;

                    bootstrap.config().group().schedule(() -> connect(bootstrap, ip, port, retry - 1), delay,
                        TimeUnit.SECONDS);
                }
            }
        });
    }

    /**
     * startConsoleThread
     *
     * @param channel Channel
     */
    private static void startConsoleThread(Channel channel) {
        new Thread(() -> {
            while (!Thread.interrupted()) {
//                if (LoginUtil.hasLogin(channel)) {
                    logger.info("Input Message:");
                    Scanner in = new Scanner(System.in);
                    String message = in.nextLine();

                    for (int i = 0; i < 1; i++) {
                        MessageRequestPacket requestPacket = new MessageRequestPacket();
                        requestPacket.setMessage(message);
                        ByteBuf byteBuf = PacketCodeC.INSTANCE.encode(channel.alloc().ioBuffer(), requestPacket);
                        channel.writeAndFlush(byteBuf);
                    }
//                }
            }
        }).start();
    }
}
