package com.jailmango.netty.lightman.netty.app.client.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import com.jailmango.netty.lightman.netty.app.packet.response.LogoutResponsePacket;
import com.jailmango.netty.lightman.netty.app.util.SessionUtil;

/**
 * LogoutResponseHandler
 *
 * @author he.gang33
 * @CreateDate 2019/12/6
 * @see com.jailmango.netty.lightman.netty.app.client.handler
 * @since R9.0
 */
public class LogoutResponseHandler extends SimpleChannelInboundHandler<LogoutResponsePacket> {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(LogoutResponseHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LogoutResponsePacket msg) throws Exception {
        SessionUtil.unbindSession(ctx.channel());
        logger.info("解绑Session...");
    }
}
