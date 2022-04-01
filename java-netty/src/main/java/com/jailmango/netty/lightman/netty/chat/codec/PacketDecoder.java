package com.jailmango.netty.lightman.netty.chat.codec;

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
 * @CreateDate 2019-08-12
 * @see com.jailmango.netty.lightman.netty.chat.codec
 * @since R9.0
 */
public class PacketDecoder extends ByteToMessageDecoder {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(PacketDecoder.class);

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        logger.info("PacketDecoder.decode start...");

        out.add(PacketCodeC.INSTANCE.decode(in));

        logger.info("PacketDecoder.decode end...");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        logger.info("channelReadComplete -> channel某次数据读完");
        super.channelReadComplete(ctx);
    }
}
