package com.jailmango.netty.lightman.netty.app.client.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import com.jailmango.netty.lightman.netty.app.packet.response.MessageResponsePacket;

/**
 * MessageResponseHandler
 *
 * @author jailmango
 * @CreateDate 2019/9/19
 * @see com.jailmango.netty.lightman.netty.app.client.handler
 * @since R9.0
 */
public class MessageResponseHandler extends SimpleChannelInboundHandler<MessageResponsePacket> {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(MessageResponseHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageResponsePacket msg) throws Exception {
        logger.info("收到[{}]发送的消息 -> {}", msg.getFromUserName(), msg.getMessage());
    }
}
