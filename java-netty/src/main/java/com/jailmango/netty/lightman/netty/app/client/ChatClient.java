package com.jailmango.netty.lightman.netty.app.client;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import com.jailmango.netty.lightman.netty.app.client.console.ConsoleCommand;
import com.jailmango.netty.lightman.netty.app.client.console.ConsoleCommandManager;
import com.jailmango.netty.lightman.netty.app.client.console.impl.LoginConsoleCommand;
import com.jailmango.netty.lightman.netty.app.client.handler.CreateGroupResponseHandler;
import com.jailmango.netty.lightman.netty.app.client.handler.GroupMessageResponseHandler;
import com.jailmango.netty.lightman.netty.app.client.handler.HeartBeatSenderHandler;
import com.jailmango.netty.lightman.netty.app.client.handler.JoinGroupResponseHandler;
import com.jailmango.netty.lightman.netty.app.client.handler.ListGroupMembersResponseHandler;
import com.jailmango.netty.lightman.netty.app.client.handler.LoginResponseHandler;
import com.jailmango.netty.lightman.netty.app.client.handler.LogoutResponseHandler;
import com.jailmango.netty.lightman.netty.app.client.handler.MessageResponseHandler;
import com.jailmango.netty.lightman.netty.app.client.handler.QuitGroupResponseHandler;
import com.jailmango.netty.lightman.netty.app.codec.CustomSpliter;
import com.jailmango.netty.lightman.netty.app.codec.PacketDecoder;
import com.jailmango.netty.lightman.netty.app.codec.PacketEncoder;
import com.jailmango.netty.lightman.netty.app.handler.IMIdleStateHandler;
import com.jailmango.netty.lightman.netty.app.util.SessionUtil;

/**
 * ChatClient
 *
 * @author he.gang33
 * @CreateDate 2019/9/3
 * @see com.jailmango.netty.lightman.netty.app.client
 * @since R9.0
 */
public class ChatClient {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ChatClient.class);

    /**
     * 默认密码
     */
    private static final String DEFAULT_PWD = "pwd";

    /**
     * MAX_RETRY
     */
    private static final int MAX_RETRY = 2;

    public static void main(String[] args) {
        Bootstrap bootstrap = new Bootstrap();
        NioEventLoopGroup group = new NioEventLoopGroup();

        bootstrap.group(group).channel(NioSocketChannel.class).option(ChannelOption.SO_KEEPALIVE, true)
            .handler(new ChannelInitializer<NioSocketChannel>() {
                @Override
                protected void initChannel(NioSocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new IMIdleStateHandler());
                    ch.pipeline().addLast(new CustomSpliter());
                    ch.pipeline().addLast(new PacketDecoder());
                    ch.pipeline().addLast(new LoginResponseHandler());
                    ch.pipeline().addLast(new MessageResponseHandler());
                    ch.pipeline().addLast(new CreateGroupResponseHandler());
                    ch.pipeline().addLast(new JoinGroupResponseHandler());
                    ch.pipeline().addLast(new QuitGroupResponseHandler());
                    ch.pipeline().addLast(new ListGroupMembersResponseHandler());
                    ch.pipeline().addLast(new GroupMessageResponseHandler());
                    ch.pipeline().addLast(new LogoutResponseHandler());
                    ch.pipeline().addLast(new PacketEncoder());
                    ch.pipeline().addLast(new HeartBeatSenderHandler());
                }
            });

        String ip = "127.0.0.1";
        int port = 8080;

        connect(bootstrap, ip, port, MAX_RETRY);
    }

    private static void connect(Bootstrap bootstrap, String ip, int port, int retry) {
        bootstrap.connect(ip, port).addListener(future -> {
            if (future.isSuccess()) {
                logger.info("聊天客户端启动成功...");
                Channel channel = ((ChannelFuture) future).channel();
                startConsoleThread(channel);
            }
            else {
                if (0 == retry) {
                    logger.info("重启次数达到上限... 关闭客户端...");
                    bootstrap.config().group().shutdownGracefully();
                }
                else {
                    logger.info("重启...");

                    int order = MAX_RETRY - retry + 1;
                    int delay = 1 << order;

                    bootstrap.config().group().schedule(() -> connect(bootstrap, ip, port, retry - 1), delay,
                        TimeUnit.SECONDS);
                }
            }
        });
    }

    /**
     * startConsoleThread
     * 
     * @param channel Channel
     */
    private static void startConsoleThread(Channel channel) {
        ConsoleCommandManager manager = new ConsoleCommandManager();
        Scanner sc = new Scanner(System.in);
        ConsoleCommand loginConsoleCommand = new LoginConsoleCommand();

        new Thread(() -> {
            while (!Thread.interrupted()) {
                if (!SessionUtil.hasLogin(channel)) {
                    loginConsoleCommand.execute(sc, channel);
                }
                else {
                    while (SessionUtil.hasLogin(channel)) {
                        manager.execute(sc, channel);
                    }
                }
            }
        }).start();
    }

}
