package com.jailmango.netty.lightman.netty.chat.codec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import com.jailmango.netty.lightman.netty.chat.packet.Packet;

/**
 * PacketEncoder
 *
 * @author he.gang33
 * @CreateDate 2019-08-12
 * @see com.jailmango.netty.lightman.netty.chat.codec
 * @since R9.0
 */
public class PacketEncoder extends MessageToByteEncoder<Packet> {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(PacketEncoder.class);

    @Override
    protected void encode(ChannelHandlerContext ctx, Packet msg, ByteBuf out) throws Exception {
        logger.info("PacketEncoder.encode start...");

        PacketCodeC.INSTANCE.encode(out, msg);

        logger.info("PacketEncoder.encode end...");
    }
}
