package com.jailmango.netty.lightman.netty.chapter11;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * NettyClient
 *
 * @author he.gang33
 * @CreateDate 2019-08-12
 * @see com.jailmango.netty.lightman.netty.chapter11
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

    public static void main(String[] args) {
        Bootstrap bootstrap = new Bootstrap();
        NioEventLoopGroup group = new NioEventLoopGroup();

        bootstrap.group(group).channel(NioSocketChannel.class).handler(new ClientHandler());

        String ip = "127.0.0.1";
        int port = 8080;
        connect(bootstrap, ip, port, MAX_RETRY);
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
                logger.info("Input Message...");
                Scanner in = new Scanner(System.in);
                String message = in.nextLine();

                ByteBuf byteBuf = channel.alloc().ioBuffer();
                byteBuf.writeBytes(message.getBytes());
                channel.writeAndFlush(byteBuf);
            }
        }).start();
    }
}
