package com.jailmango.netty.lightman.netty.chat.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import com.jailmango.netty.lightman.netty.chat.server.handler.FirstServerHandler;

/**
 * NettyServer
 *
 * @author he.gang33
 * @CreateDate 2019-07-31
 * @see com.jailmango.netty.lightman.netty
 * @since R9.0
 */
public class FirstNettyServer {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(FirstNettyServer.class);

    /**
     * main
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        logger.info("NIO Server starting...");

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup worker = new NioEventLoopGroup();

        // bind()方法是异步的。
        serverBootstrap.group(boss, worker).channel(NioServerSocketChannel.class)
            .childHandler(new ChannelInitializer<NioSocketChannel>() {
                @Override
                protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
                    nioSocketChannel.pipeline().addLast(new FirstServerHandler());
                }
            }).bind(8080).addListener(future -> {
                if (future.isSuccess()) {
                    logger.info("Succeed in binding...");
                }
                else {
                    logger.info("Fail to bind...");
                }
            });

        logger.info("Main Thread end...");
    }

}
