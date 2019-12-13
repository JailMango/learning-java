package com.jailmango.netty.lightman.netty.chapter13.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;

import com.jailmango.netty.lightman.netty.chapter13.server.handler.ServerHandler;

/**
 * Server
 *
 * @author he.gang33
 * @CreateDate 2019-08-13
 * @see com.jailmango.netty.lightman.netty.chapter13.server
 * @since R9.0
 */
public class Server {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Server.class);

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
                    // 基于行的拆包器
                    ch.pipeline().addLast(new LineBasedFrameDecoder(Integer.MAX_VALUE));
                    ch.pipeline().addLast(new ServerHandler());
                }
            }).bind(8080).addListener(future -> {
                if (future.isSuccess()) {
                    logger.info("Netty Server Started...");
                }
                else {
                    logger.info("Fail to start...");
                }
            });

        logger.info("Main Thread end...");
    }
}