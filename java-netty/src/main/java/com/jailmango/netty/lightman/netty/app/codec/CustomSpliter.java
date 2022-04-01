package com.jailmango.netty.lightman.netty.app.codec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

import com.jailmango.netty.lightman.netty.app.constant.ProtocolConstant;

/**
 * CustomSpliter
 *
 * @author jailmango
 * @CreateDate 2019/9/5
 * @see com.jailmango.netty.lightman.netty.app.codec
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
        logger.info("基于长度域拆包器拆包...");

        if (in.getInt(in.readerIndex()) != ProtocolConstant.MAGIC_NUMBER) {
            logger.info("协议[Magic Number]错误...");
        }

        return super.decode(ctx, in);
    }
}
