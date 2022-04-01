package com.jailmango.netty.lightman.netty.heart.client.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * HeartBeatClientHandler
 *
 * @author jailmango
 * @CreateDate 2019/8/29
 * @see com.jailmango.netty.lightman.netty.heart.client.handler
 * @since R9.0
 */
public class HeartBeatClientHandler extends ChannelInboundHandlerAdapter {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(HeartBeatClientHandler.class);

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        logger.info("write no message for a long time...");

        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;

            if (event.state() == IdleState.WRITER_IDLE) {
                logger.info("send heart beat message...");
                ctx.channel().writeAndFlush("di. di. di.");
            }
        }
        else {
            super.userEventTriggered(ctx, evt);
        }
    }
}
