package com.jailmango.netty.lightman.netty.chat.server.handler;

import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * FirstServerHandler
 *
 * @author jailmango
 * @CreateDate 2019-08-05
 * @see com.jailmango.netty.lightman.netty
 * @since R9.0
 */
public class FirstServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(FirstServerHandler.class);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String message = ((ByteBuf) msg).toString(StandardCharsets.UTF_8);
        logger.info("Server Receive: [{}]", message);

        ByteBuf response = ctx.alloc().buffer();
        response.writeBytes((message + "-response").getBytes(StandardCharsets.UTF_8));
        ctx.channel().writeAndFlush(response);
    }
}
