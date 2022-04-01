package com.jailmango.netty.lightman.netty.app.handler;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;

/**
 * IMIdleStateHandler
 *
 * @author jailmango
 * @CreateDate 2019/12/13
 * @see com.jailmango.netty.lightman.netty.app.handler
 * @since R9.0
 */
public class IMIdleStateHandler extends IdleStateHandler {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(IMIdleStateHandler.class);

    /**
     * READER_IDLE_TIME
     */
    private static final int READER_IDLE_TIME = 15;

    /**
     * Constructor
     */
    public IMIdleStateHandler() {
        super(READER_IDLE_TIME, 0, 0, TimeUnit.SECONDS);
    }

    @Override
    protected void channelIdle(ChannelHandlerContext ctx, IdleStateEvent evt) throws Exception {
        logger.info("未收到心跳消息...");
        // ctx.channel().close();
    }
}
