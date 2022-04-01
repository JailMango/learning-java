package com.jailmango.netty.lightman.netty.app.server.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

/**
 * OutBoundHandler
 *
 * @author jailmango
 * @CreateDate 2019/12/11
 * @see com.jailmango.netty.lightman.netty.app.server.handler
 * @since R9.0
 */
public class OutBoundHandler extends ChannelOutboundHandlerAdapter {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(OutBoundHandler.class);

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        logger.info("测试OutBoundHandler...");
        super.write(ctx, msg, promise);
    }
}
