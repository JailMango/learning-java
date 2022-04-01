package com.jailmango.netty.lightman.netty.chapter11;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jailmango.netty.lightman.netty.chat.attribute.Attributes;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

/**
 * OutboundHandlerA
 *
 * @author jailmango
 * @CreateDate 2019-08-12
 * @see com.jailmango.netty.lightman.netty.chapter11
 * @since R9.0
 */
public class OutboundHandlerC extends ChannelOutboundHandlerAdapter {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(OutboundHandlerC.class);

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        logger.info("OutboundHandlerC[{}] -> {}", ctx.channel().attr(Attributes.COMPLETED_DATE).get(), msg);

        ByteBuf byteBuf = (ByteBuf) msg;
        byteBuf.writeBytes(" -> C".getBytes());

        ctx.channel().attr(Attributes.COMPLETED_DATE).set(new Date());

        super.write(ctx, msg, promise);
    }
}
