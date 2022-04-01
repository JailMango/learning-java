package com.jailmango.netty.lightman.netty.app.server.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import com.jailmango.netty.lightman.netty.app.util.SessionUtil;

/**
 * AuthHandler
 *
 * @author jailmango
 * @CreateDate 2019/9/19
 * @see com.jailmango.netty.lightman.netty.app.server.handler
 * @since R9.0
 */
@ChannelHandler.Sharable
public class AuthHandler extends ChannelInboundHandlerAdapter {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(AuthHandler.class);

    /**
     * instance
     */
    public static final AuthHandler INSTANCE = new AuthHandler();

    /**
     * Constructor
     */
    private AuthHandler() {

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (!SessionUtil.hasLogin(ctx.channel())) {
            logger.info("未登录, 关闭连接...");
            ctx.channel().close();
        }
        else {
            ctx.pipeline().remove(this);
            logger.info("已经登录过. 删除该校验器...");
            super.channelRead(ctx, msg);
        }
    }
}
