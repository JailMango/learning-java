package com.jailmango.netty.lightman.netty.chat.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.timeout.IdleStateHandler;

import com.jailmango.netty.lightman.netty.chat.codec.CustomSpliter;
import com.jailmango.netty.lightman.netty.chat.codec.PacketDecoder;
import com.jailmango.netty.lightman.netty.chat.codec.PacketEncoder;
import com.jailmango.netty.lightman.netty.chat.counter.ClientCounter;
import com.jailmango.netty.lightman.netty.chat.server.handler.AuthHandler;
import com.jailmango.netty.lightman.netty.chat.server.handler.LifeCycleHandler;
import com.jailmango.netty.lightman.netty.chat.server.handler.LoginRequestHandler;
import com.jailmango.netty.lightman.netty.chat.server.handler.MessageRequestHandler;

/**
 * NettyServer
 *
 * @author he.gang33
 * @CreateDate 2019-08-08
 * @see com.jailmango.netty.lightman.netty.chat.server
 * @since R9.0
 */
public class NettyServer {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(NettyServer.class);

    /**
     * main
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        logger.info("Netty Server starting...");

        ServerBootstrap bootstrap = new ServerBootstrap();
        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup worker = new NioEventLoopGroup();

        bootstrap.group(boss, worker).channel(NioServerSocketChannel.class).option(ChannelOption.SO_BACKLOG, 1024)
            .childOption(ChannelOption.SO_KEEPALIVE, true).childOption(ChannelOption.TCP_NODELAY, true)
            .childHandler(new ChannelInitializer<NioSocketChannel>() {
                @Override
                protected void initChannel(NioSocketChannel ch) {
                    // 心跳
                    ch.pipeline().addLast(new IdleStateHandler(5, 0, 0));
                    ch.pipeline().addLast(new LifeCycleHandler());
                    // 基于长度域拆包器
                    ch.pipeline().addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 7, 4));
                    // 如果服务端取消该拆包器，当客户端连续连续发送消息时，会出有关ByteBuf的异常。
                    ch.pipeline().addLast(new CustomSpliter());
                    ch.pipeline().addLast(new PacketDecoder());
                    ch.pipeline().addLast(new LoginRequestHandler());
                    ch.pipeline().addLast(new AuthHandler());
                    ch.pipeline().addLast(new MessageRequestHandler());
                    ch.pipeline().addLast(new PacketEncoder());
                }
            }).bind(8080).addListener(future -> {
                if (future.isSuccess()) {
                    startBackThread();
                    logger.info("Netty Server started...");
                }
                else {
                    logger.info("Failed to start...");
                }
            });

        logger.info("Main Thread end...");
    }

    /**
     * startBackThread
     */
    private static void startBackThread() {
        new Thread(() -> {
            while (true) {
                logger.info("Current Client: [{}]", ClientCounter.INSTANCE.getClientCount());
                try {
                    Thread.sleep(10000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
