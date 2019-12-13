package com.jailmango.netty.lightman.netty.chapter11;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jailmango.netty.lightman.netty.chat.attribute.Attributes;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * InboundHandlerA
 *
 * @author he.gang33
 * @CreateDate 2019-08-12
 * @see com.jailmango.netty.lightman.netty.chapter11
 * @since R9.0
 */
public class InboundHandlerB extends ChannelInboundHandlerAdapter {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(InboundHandlerB.class);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        logger.info("InboundHandlerB[{}] -> {}", ctx.channel().attr(Attributes.COMPLETED_DATE).get(), msg);
        ctx.channel().attr(Attributes.COMPLETED_DATE).set(new Date());
        super.channelRead(ctx, msg);
    }
}
