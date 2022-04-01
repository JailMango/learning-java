package com.jailmango.netty.lightman.netty.app.server.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import com.jailmango.netty.lightman.netty.app.counter.ClientCounter;

/**
 * CounterHandler
 *
 * @author jailmango
 * @CreateDate 2019/9/18
 * @see com.jailmango.netty.lightman.netty.app.server.handler
 * @since R9.0
 */
public class CounterHandler extends ChannelInboundHandlerAdapter {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(CounterHandler.class);

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ClientCounter.INSTANCE.connect();
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        ClientCounter.INSTANCE.disconnect();
        super.channelInactive(ctx);
    }
}
