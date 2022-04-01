package com.jailmango.netty.lightman.netty.heart.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;

import com.jailmango.netty.lightman.netty.heart.client.handler.HeartBeatClientHandler;

/**
 * HeartBeatClient
 *
 * @author jailmango
 * @CreateDate 2019/8/29
 * @see com.jailmango.netty.lightman.netty.heart.client
 * @since R9.0
 */
public class HeartBeatClient {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(HeartBeatClient.class);

    public static void main(String[] args) {
        Bootstrap bootstrap = new Bootstrap();
        NioEventLoopGroup group = new NioEventLoopGroup();

        bootstrap.group(group).channel(NioSocketChannel.class).option(ChannelOption.SO_KEEPALIVE, true)
            .handler(new ChannelInitializer<NioSocketChannel>() {
                @Override
                protected void initChannel(NioSocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new IdleStateHandler(0, 2, 0));
                    ch.pipeline().addLast(new StringEncoder());
                    ch.pipeline().addLast(new HeartBeatClientHandler());
                }
            }).connect("127.0.0.1", 8080).addListener(future -> {
                if (future.isSuccess()) {
                    logger.info("connected to server...");
                }
                else {
                    logger.info("fail to connect to server");
                    bootstrap.config().group().shutdownGracefully();
                }
            });
    }

}
