package com.jailmango.netty.lightman.netty.chat.client.handler;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jailmango.netty.lightman.netty.chat.bytebuf.ByteBufInfo;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * FirstClientHandler
 *
 * @author jailmango
 * @CreateDate 2019-08-05
 * @see com.jailmango.netty.lightman.netty
 * @since R9.0
 */
public class FirstClientHandler extends ChannelInboundHandlerAdapter {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(FirstClientHandler.class);

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ByteBuf byteBuf = getMessage(ctx);
        ctx.channel().writeAndFlush(byteBuf);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        logger.info("Client Receive: [{}]", ((ByteBuf) msg).toString(StandardCharsets.UTF_8));
    }

    /**
     * getMessage
     * 
     * @param ctx ChannelHandlerContext
     * @return ByteBuf
     */
    private ByteBuf getMessage(ChannelHandlerContext ctx) {
        ByteBuf byteBuf = ctx.alloc().buffer();

        ByteBufInfo.getByteBufInfo(byteBuf);

        byte[] bytes = ("Data-" + new Date()).getBytes(StandardCharsets.UTF_8);
        byteBuf.writeBytes(bytes);

        ByteBufInfo.getByteBufInfo(byteBuf);

        return byteBuf;
    }
}
