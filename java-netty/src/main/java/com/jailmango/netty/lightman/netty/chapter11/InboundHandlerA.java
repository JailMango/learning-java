package com.jailmango.netty.lightman.netty.chapter11;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import com.jailmango.netty.lightman.netty.chat.attribute.Attributes;

/**
 * InboundHandlerA
 *
 * @author he.gang33
 * @CreateDate 2019-08-12
 * @see com.jailmango.netty.lightman.netty.chapter11
 * @since R9.0
 */
public class InboundHandlerA extends ChannelInboundHandlerAdapter {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(InboundHandlerA.class);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        logger.info("InboundHandlerA -> {}", msg);
        ctx.channel().attr(Attributes.COMPLETED_DATE).set(new Date());
        super.channelRead(ctx, msg);
    }
}
