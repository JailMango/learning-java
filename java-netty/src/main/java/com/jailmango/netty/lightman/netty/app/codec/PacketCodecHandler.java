package com.jailmango.netty.lightman.netty.app.codec;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;

import com.jailmango.netty.lightman.netty.app.packet.Packet;

/**
 * PacketCodecHandler
 *
 * @author he.gang33
 * @CreateDate 2019/12/9
 * @see com.jailmango.netty.lightman.netty.app.codec
 * @since R9.0
 */
@ChannelHandler.Sharable
public class PacketCodecHandler extends MessageToMessageCodec<ByteBuf, Packet> {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(PacketCodecHandler.class);

    /**
     * instance
     */
    public static final PacketCodecHandler INSTANCE = new PacketCodecHandler();

    /**
     * Constructor
     */
    private PacketCodecHandler() {

    }

    @Override
    protected void encode(ChannelHandlerContext ctx, Packet msg, List<Object> out) throws Exception {
        logger.info("PacketCodecHandler编码...");
        ByteBuf byteBuf = ctx.channel().alloc().ioBuffer();
        PacketCodec.INSTANCE.encode(byteBuf, msg);
        out.add(byteBuf);
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        logger.info("PacketCodecHandler解码...");
        out.add(PacketCodec.INSTANCE.decode(msg));
    }
}
