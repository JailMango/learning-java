package com.jailmango.netty.lightman.netty.chapter11;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * NettyServer
 *
 * @author jailmango
 * @CreateDate 2019-08-12
 * @see com.jailmango.netty.lightman.netty.chapter11
 * @since R9.0
 */
public class NettyServer {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(NettyServer.class);

    public static void main(String[] args) {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup worker = new NioEventLoopGroup();

        serverBootstrap.group(boss, worker).channel(NioServerSocketChannel.class)
            .childHandler(new ChannelInitializer<NioSocketChannel>() {
                @Override
                protected void initChannel(NioSocketChannel ch) throws Exception {
                    // Inbound 顺序[A -> B -> C]
                    ch.pipeline().addLast(new InboundHandlerA());
                    ch.pipeline().addLast(new InboundHandlerB());
                    ch.pipeline().addLast(new InboundHandlerC());
                    // Outbound 倒序[C -> B -> A]
                    ch.pipeline().addLast(new OutboundHandlerA());
                    ch.pipeline().addLast(new OutboundHandlerB());
                    ch.pipeline().addLast(new OutboundHandlerC());
                }
            }).bind(8080).addListener(future -> {
                if (future.isSuccess()) {
                    logger.info("Netty Server started...");
                }
                else {
                    logger.info("Failed to start...");
                }
            });
    }
}
