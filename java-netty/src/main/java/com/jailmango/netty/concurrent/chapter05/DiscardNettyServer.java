package com.jailmango.netty.concurrent.chapter05;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import lombok.extern.slf4j.Slf4j;

/**
 * DiscardNettyServer
 *
 * @author jailmango
 * @CreateDate 2021/12/6
 * @see com.jailmango.netty.concurrent.chapter05
 */
@Slf4j
public class DiscardNettyServer {

    private static final int PORT = 8080;

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {

    }

    private void runServer() {
        // ServerBootstrap
        ServerBootstrap server = new ServerBootstrap();
        // boss thread
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        // worker thread
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        server.group(bossGroup, workerGroup);
    }
}
