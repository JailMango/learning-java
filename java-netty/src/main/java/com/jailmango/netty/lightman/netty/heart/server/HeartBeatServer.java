package com.jailmango.netty.lightman.netty.heart.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.timeout.IdleStateHandler;

import com.jailmango.netty.lightman.netty.heart.server.handler.HeartBeatServerHandler;

/**
 * HeartBeatServer
 *
 * @author he.gang33
 * @CreateDate 2019/8/29
 * @see com.jailmango.netty.lightman.netty.heart.server
 * @since R9.0
 */
public class HeartBeatServer {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(HeartBeatServer.class);

    /**
     * main
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup worker = new NioEventLoopGroup();

        serverBootstrap.group(boss, worker).channel(NioServerSocketChannel.class).option(ChannelOption.SO_BACKLOG, 1024)
            .childOption(ChannelOption.SO_KEEPALIVE, true).childOption(ChannelOption.TCP_NODELAY, true)
            .childHandler(new ChannelInitializer<NioSocketChannel>() {
                @Override
                protected void initChannel(NioSocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new IdleStateHandler(4, 0, 0));
                    ch.pipeline().addLast(new StringDecoder());
                    ch.pipeline().addLast(new HeartBeatServerHandler());
                }
            }).bind(8080).addListener(future -> {
                if (future.isSuccess()) {
                    logger.info("Server started...");
                }
                else {
                    logger.info("Fail to start...");
                }
            });
    }

}
