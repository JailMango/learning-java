package com.jailmango.netty.lightman.netty.chapter13.client.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * ClientHandler
 *
 * @author he.gang33
 * @CreateDate 2019-08-13
 * @see com.jailmango.netty.lightman.netty.chapter13.client.handler
 * @since R9.0
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ClientHandler.class);

    /**
     * Message
     */
    private static final String MESSAGE = "你好，欢迎关注我的微信公众号，《闪电侠的博客》!" + System.lineSeparator();

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i < 1000; i++) {
            ByteBuf byteBuf = getByteBuf(ctx);
            ctx.channel().writeAndFlush(byteBuf);
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
    }

    /**
     * getByteBuf
     * 
     * @param ctx ChannelHandlerContext
     * @return ByteBuf
     */
    private ByteBuf getByteBuf(ChannelHandlerContext ctx) {
        ByteBuf byteBuf = ctx.alloc().ioBuffer();
        byteBuf.writeBytes(MESSAGE.getBytes());
        return byteBuf;
    }
}
