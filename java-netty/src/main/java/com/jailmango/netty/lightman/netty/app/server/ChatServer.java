package com.jailmango.netty.lightman.netty.app.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import com.jailmango.netty.lightman.netty.app.codec.CustomSpliter;
import com.jailmango.netty.lightman.netty.app.codec.PacketCodecHandler;
import com.jailmango.netty.lightman.netty.app.counter.ClientCounter;
import com.jailmango.netty.lightman.netty.app.server.handler.AnotherOutBoundHandler;
import com.jailmango.netty.lightman.netty.app.server.handler.AuthHandler;
import com.jailmango.netty.lightman.netty.app.server.handler.CounterHandler;
import com.jailmango.netty.lightman.netty.app.server.handler.HeartBeatRequestHandler;
import com.jailmango.netty.lightman.netty.app.server.handler.IMHandler;
import com.jailmango.netty.lightman.netty.app.server.handler.LoginRequestHandler;
import com.jailmango.netty.lightman.netty.app.server.handler.OutBoundHandler;
import com.jailmango.netty.lightman.netty.app.server.handler.WasteTimeHandler;

/**
 * ChatServer
 *
 * @author jailmango
 * @CreateDate 2019/9/3
 * @see com.jailmango.netty.lightman.netty.app.server
 * @since R9.0
 */
public class ChatServer {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ChatServer.class);

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
                    ch.pipeline().addLast(new CounterHandler());
                    // ch.pipeline().addLast(new IMIdleStateHandler());
                    ch.pipeline().addLast(new CustomSpliter());
                    ch.pipeline().addLast(PacketCodecHandler.INSTANCE);
                    ch.pipeline().addLast(LoginRequestHandler.INSTANCE);
                    ch.pipeline().addLast(HeartBeatRequestHandler.INSTANCE);
                    ch.pipeline().addLast(AuthHandler.INSTANCE);
                    ch.pipeline().addLast(WasteTimeHandler.INSTANCE);
                    // 压缩handler, 合并平行handler
                    ch.pipeline().addLast(IMHandler.INSTANCE);
                    // 测试OutBoundHandler
                    ch.pipeline().addLast(new OutBoundHandler());
                    ch.pipeline().addLast(new AnotherOutBoundHandler());
                }
            }).bind(8080).addListener(future -> {
                if (future.isSuccess()) {
                    logger.info("聊天服务器启动成功...");
                    startCounterThread();
                }
                else {
                    logger.info("聊天服务器启动失败...");
                }
            });
    }

    /**
     * 启动客户端计数线程
     */
    private static void startCounterThread() {
        new Thread(() -> {
            while (true) {
                logger.info("当前客户端数量: [{}]", ClientCounter.INSTANCE.getCount());
                try {
                    Thread.sleep(10000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                    logger.error(e.getMessage());
                }
            }
        }, "Thread-ClientCounter").start();
    }

}
