package com.jailmango.netty.lightman.netty.app.server.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import com.jailmango.netty.lightman.netty.app.packet.request.HeartBeatRequestPacket;
import com.jailmango.netty.lightman.netty.app.packet.response.HeartBeatResponsePacket;

/**
 * HeartBeatRequestHandler
 *
 * @author he.gang33
 * @CreateDate 2019/12/16
 * @see com.jailmango.netty.lightman.netty.app.server.handler
 * @since R9.0
 */
@ChannelHandler.Sharable
public class HeartBeatRequestHandler extends SimpleChannelInboundHandler<HeartBeatRequestPacket> {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(HeartBeatRequestHandler.class);

    /**
     * instance
     */
    public static final HeartBeatRequestHandler INSTANCE = new HeartBeatRequestHandler();

    /**
     * Constructor
     */
    private HeartBeatRequestHandler() {

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HeartBeatRequestPacket msg) throws Exception {
        logger.info("服务器收到客户端心跳消息...");
        ctx.writeAndFlush(new HeartBeatResponsePacket());
    }
}
