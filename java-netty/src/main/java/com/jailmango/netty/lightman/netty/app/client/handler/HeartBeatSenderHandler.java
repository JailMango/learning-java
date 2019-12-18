package com.jailmango.netty.lightman.netty.app.client.handler;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import com.jailmango.netty.lightman.netty.app.packet.request.HeartBeatRequestPacket;
import com.jailmango.netty.lightman.netty.heart.server.handler.HeartBeatServerHandler;

/**
 * HeartBeatSenderHandler
 *
 * @author he.gang33
 * @CreateDate 2019/12/16
 * @see com.jailmango.netty.lightman.netty.app.client.handler
 * @since R9.0
 */
public class HeartBeatSenderHandler extends ChannelInboundHandlerAdapter {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(HeartBeatServerHandler.class);

    /**
     * 发送心跳消息请求间隔
     */
    private static final int HEART_BEAT_INTERVAL = 10;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        scheduleSendHeartBeat(ctx);
        super.channelActive(ctx);
    }

    private void scheduleSendHeartBeat(ChannelHandlerContext ctx) {
        ctx.executor().schedule(() -> {
            ctx.writeAndFlush(new HeartBeatRequestPacket());
            logger.info("客户端发送了心跳消息...");
            scheduleSendHeartBeat(ctx);
        }, HEART_BEAT_INTERVAL, TimeUnit.SECONDS);
    }
}
