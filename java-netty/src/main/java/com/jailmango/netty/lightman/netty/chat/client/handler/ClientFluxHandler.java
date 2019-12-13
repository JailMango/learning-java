package com.jailmango.netty.lightman.netty.chat.client.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import com.jailmango.netty.lightman.netty.chat.counter.FluxCounter;

/**
 * ClientFluxHandler
 *
 * @author he.gang33
 * @CreateDate 2019/9/3
 * @see com.jailmango.netty.lightman.netty.chat.client.handler
 * @since R9.0
 */
public class ClientFluxHandler extends ChannelInboundHandlerAdapter {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ClientFluxHandler.class);

    /**
     * fluxCounter
     */
    private FluxCounter fluxCounter = new FluxCounter();

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        Long total = fluxCounter.record(byteBuf.writerIndex());

        logger.info("Total Flux: [{}]", total);

        super.channelRead(ctx, msg);
    }
}
