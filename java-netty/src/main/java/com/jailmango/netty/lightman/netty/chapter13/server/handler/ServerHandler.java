package com.jailmango.netty.lightman.netty.chapter13.server.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * ServerHandler
 *
 * @author he.gang33
 * @CreateDate 2019-08-13
 * @see com.jailmango.netty.lightman.netty.chapter13.server.handler
 * @since R9.0
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ServerHandler.class);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        logger.info("{}", byteBuf.toString(CharsetUtil.UTF_8));
    }
}
