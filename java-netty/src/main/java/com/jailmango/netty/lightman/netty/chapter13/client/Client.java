package com.jailmango.netty.lightman.netty.chapter13.client;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jailmango.netty.lightman.netty.chapter13.client.handler.ClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Client
 *
 * @author he.gang33
 * @CreateDate 2019-08-13
 * @see com.jailmango.netty.lightman.netty.chapter13.client
 * @since R9.0
 */
public class Client {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Client.class);

    /**
     * MAX_RETRY
     */
    private static final int MAX_RETRY = 4;

    public static void main(String[] args) {
        Bootstrap bootstrap = new Bootstrap();
        NioEventLoopGroup group = new NioEventLoopGroup();

        bootstrap.group(group).channel(NioSocketChannel.class).option(ChannelOption.SO_KEEPALIVE, true)
            .option(ChannelOption.TCP_NODELAY, true).handler(new ChannelInitializer<NioSocketChannel>() {
                @Override
                protected void initChannel(NioSocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new ClientHandler());
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
        bootstrap.connect(ip, port).addListener(future -> {
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
        });
    }
}
