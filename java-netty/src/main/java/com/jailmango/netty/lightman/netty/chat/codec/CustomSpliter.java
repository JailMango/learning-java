package com.jailmango.netty.lightman.netty.chat.codec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * CustomSpliter
 *
 * @author he.gang33
 * @CreateDate 2019-08-15
 * @see com.jailmango.netty.lightman.netty.chat.codec
 * @since R9.0
 */
public class CustomSpliter extends LengthFieldBasedFrameDecoder {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(CustomSpliter.class);

    /**
     * LENGTH_FIELD_OFFSET
     */
    private static final int LENGTH_FIELD_OFFSET = 7;

    /**
     * LENGTH_FIELD_LENGTH
     */
    private static final int LENGTH_FIELD_LENGTH = 4;

    /**
     * Constructor
     */
    public CustomSpliter() {
        super(Integer.MAX_VALUE, LENGTH_FIELD_OFFSET, LENGTH_FIELD_LENGTH);
    }

    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        logger.info("CustomSpliter.decode start...");
        if (in.getInt(in.readerIndex()) != PacketCodeC.MAGIC_NUMBER) {
            logger.info("Error Protocol...");
            ctx.channel().close();
            return null;
        }

        logger.info("Client Count: [{}]");

        return super.decode(ctx, in);
    }
}
