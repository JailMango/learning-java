package com.jailmango.netty.lightman.netty.app.client.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import com.jailmango.netty.lightman.netty.app.packet.response.GroupMessageResponsePacket;

/**
 * GroupMessageResponseHandler
 *
 * @author he.gang33
 * @CreateDate 2019/12/6
 * @see com.jailmango.netty.lightman.netty.app.client.handler
 * @since R9.0
 */
public class GroupMessageResponseHandler extends SimpleChannelInboundHandler<GroupMessageResponsePacket> {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(GroupMessageResponseHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GroupMessageResponsePacket msg) throws Exception {
        logger.info("收到群聊[{}][{}]发送的消息 -> {}", msg.getFromGroupName(), msg.getFromUserName(), msg.getMessage());
    }
}
