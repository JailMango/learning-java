package com.jailmango.netty.lightman.netty.chat.client.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import com.jailmango.netty.lightman.netty.chat.packet.response.MessageResponsePacket;

/**
 * MessageResponseHandler
 *
 * @author he.gang33
 * @CreateDate 2019-08-12
 * @see com.jailmango.netty.lightman.netty.chat.client.handler
 * @since R9.0
 */
public class MessageResponseHandler extends SimpleChannelInboundHandler<MessageResponsePacket> {
    
    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(MessageResponseHandler.class);
    

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageResponsePacket msg) throws Exception {
        logger.info("Netty Client receive message: [{}]", msg.getMessage());
    }
}
