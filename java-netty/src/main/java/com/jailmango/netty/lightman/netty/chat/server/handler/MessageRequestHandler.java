package com.jailmango.netty.lightman.netty.chat.server.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import com.jailmango.netty.lightman.netty.chat.packet.request.MessageRequestPacket;
import com.jailmango.netty.lightman.netty.chat.packet.response.MessageResponsePacket;

/**
 * MessageRequestHandler
 *
 * @author he.gang33
 * @CreateDate 2019-08-12
 * @see com.jailmango.netty.lightman.netty.chat.server.handler
 * @since R9.0
 */
public class MessageRequestHandler extends SimpleChannelInboundHandler<MessageRequestPacket> {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(MessageRequestHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageRequestPacket msg) throws Exception {
        logger.info("Netty Server receive message: [{}]", msg.getMessage());

        MessageResponsePacket responsePacket = new MessageResponsePacket();
        responsePacket.setVersion(msg.getVersion());
        responsePacket.setMessage(msg.getMessage() + "->response");

        ctx.channel().writeAndFlush(responsePacket);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        logger.info("channelReadComplete -> channel某次数据读完");
        super.channelReadComplete(ctx);
    }
}
