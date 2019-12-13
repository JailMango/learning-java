package com.jailmango.netty.lightman.netty.heart.server.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * HeartBeatServerHandler
 *
 * @author he.gang33
 * @CreateDate 2019/8/29
 * @see com.jailmango.netty.lightman.netty.chat.server.handler
 * @since R9.0
 */
public class HeartBeatServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(HeartBeatServerHandler.class);

    /**
     * counter
     */
    private int counter = 0;

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        logger.info("recevie no message for a long time...");

        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;

            if (event.state() == IdleState.READER_IDLE) {
                counter++;

                if (2 <= counter) {
                    logger.info("Close channel...");
                    ctx.channel().close();
                }
            }
        }
        else {
            super.userEventTriggered(ctx, evt);
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        counter = 0;
        logger.info("read heart beat message...");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.info("catch exception...");
        ctx.close();
    }
}
