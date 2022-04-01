package com.jailmango.netty.lightman.netty.chat.server.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import com.jailmango.netty.lightman.netty.chat.util.LoginUtil;

/**
 * AuthHandler
 *
 * @author jailmango
 * @CreateDate 2019/9/3
 * @see com.jailmango.netty.lightman.netty.chat.server.handler
 * @since R9.0
 */
public class AuthHandler extends ChannelInboundHandlerAdapter {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(AuthHandler.class);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (!LoginUtil.hasLogin(ctx.channel())) {
            ctx.channel().close();
        }
        else {
            ctx.pipeline().remove(this);
            super.channelRead(ctx, msg);
        }
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        if (LoginUtil.hasLogin(ctx.channel())) {
            logger.info("Auth success... Remove auth handler...");
        }
        else {
            logger.info("Auth fail... Close channel...");
        }
    }
}
