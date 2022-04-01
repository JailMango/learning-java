package com.jailmango.netty.lightman.netty.app.server.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import com.jailmango.netty.lightman.netty.app.packet.request.LogoutRequestPacket;
import com.jailmango.netty.lightman.netty.app.packet.response.LogoutResponsePacket;
import com.jailmango.netty.lightman.netty.app.util.SessionUtil;

/**
 * LogoutRequestHandler
 *
 * @author jailmango
 * @CreateDate 2019/12/6
 * @see com.jailmango.netty.lightman.netty.app.server.handler
 * @since R9.0
 */
@ChannelHandler.Sharable
public class LogoutRequestHandler extends SimpleChannelInboundHandler<LogoutRequestPacket> {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(LogoutRequestHandler.class);

    /**
     * instance
     */
    public static final LogoutRequestHandler INSTANCE = new LogoutRequestHandler();

    /**
     * Constructor
     */
    private LogoutRequestHandler() {

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LogoutRequestPacket msg) throws Exception {
        logger.info("开始处理登出请求...");

        SessionUtil.unbindSession(ctx.channel());
        LogoutResponsePacket responsePacket = new LogoutResponsePacket();
        responsePacket.setSuccess(true);
        ctx.writeAndFlush(responsePacket);

        logger.info("解绑Session...");
    }
}
