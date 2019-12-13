package com.jailmango.netty.lightman.netty.chat.client;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

import com.jailmango.netty.lightman.netty.chat.client.handler.FirstClientHandler;

/**
 * NettyClient
 *
 * @author he.gang33
 * @CreateDate 2019-07-31
 * @see com.jailmango.netty.lightman.netty
 * @since R9.0
 */
public class FirstNettyClient {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(FirstNettyClient.class);

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
        Bootstrap bootstrap = new Bootstrap();
        NioEventLoopGroup group = new NioEventLoopGroup();

        bootstrap.group(group).channel(NioSocketChannel.class).handler(new ChannelInitializer<Channel>() {
            @Override
            protected void initChannel(Channel channel) throws Exception {
                channel.pipeline().addLast(new FirstClientHandler());
            }
        });

        String ip = "127.0.0.1";
        int port = 8080;
        connect(bootstrap, ip, port, MAX_RETRY);

        logger.info("Main Thread stop...");
        return;
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
        bootstrap.connect(ip, port).addListener(new GenericFutureListener<Future<? super Void>>() {
            @Override
            public void operationComplete(Future<? super Void> future) throws Exception {
                if (future.isSuccess()) {
                    logger.info("Succeed in connecting...");
                }
                else {
                    logger.info("Failed to connect...");
                    if (0 == retry) {
                        logger.info("Stop retry...");
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
            }
        });
    }

}
