package com.jailmango.netty.example.discard;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * DiscardServerHandler
 *
 * @author jailmango
 * @CreateDate 2019-07-01
 * @see com.jailmango.netty.example.discard
 * @since R9.0
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(DiscardServerHandler.class);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        try {
            ByteBuf recvMsg = (ByteBuf) msg;
            int count = 0;

            if (recvMsg.isReadable()) {
                count++;
                byte[] arr = new byte[recvMsg.readableBytes()];
                recvMsg.readBytes(arr);
                logger.info("{} -> {}", count, new String(arr));
            }
        }
        finally {
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
