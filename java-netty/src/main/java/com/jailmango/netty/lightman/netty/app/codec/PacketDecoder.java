package com.jailmango.netty.lightman.netty.app.codec;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

/**
 * PacketDecoder
 *
 * @author jailmango
 * @CreateDate 2019/9/5
 * @see com.jailmango.netty.lightman.netty.app.codec
 * @since R9.0
 */
public class PacketDecoder extends ByteToMessageDecoder {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(PacketDecoder.class);

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        logger.info("解码...");
        out.add(PacketCodec.INSTANCE.decode(in));
        logger.info("解码结束...");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        logger.info("channelReadComplete...");
        super.channelReadComplete(ctx);
    }
}
