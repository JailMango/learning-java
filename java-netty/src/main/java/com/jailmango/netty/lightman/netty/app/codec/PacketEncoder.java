package com.jailmango.netty.lightman.netty.app.codec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import com.jailmango.netty.lightman.netty.app.packet.Packet;

/**
 * PacketEncoder
 *
 * @author jailmango
 * @CreateDate 2019/9/5
 * @see com.jailmango.netty.lightman.netty.app.codec
 * @since R9.0
 */
public class PacketEncoder extends MessageToByteEncoder<Packet> {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(PacketEncoder.class);

    @Override
    protected void encode(ChannelHandlerContext ctx, Packet msg, ByteBuf out) throws Exception {
        logger.info("编码...");
        PacketCodec.INSTANCE.encode(out, msg);
        logger.info("编码结束...`");
    }
}
