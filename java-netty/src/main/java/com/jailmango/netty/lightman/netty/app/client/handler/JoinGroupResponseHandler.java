package com.jailmango.netty.lightman.netty.app.client.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import com.jailmango.netty.lightman.netty.app.packet.response.JoinGroupResponsePacket;

/**
 * JoinGroupResponseHandler
 *
 * @author he.gang33
 * @CreateDate 2019/11/22
 * @see com.jailmango.netty.lightman.netty.app.client.handler
 * @since R9.0
 */
public class JoinGroupResponseHandler extends SimpleChannelInboundHandler<JoinGroupResponsePacket> {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(JoinGroupResponseHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, JoinGroupResponsePacket msg) throws Exception {
        if (msg.isSuccess()) {
            logger.info("[{}]加入群聊[{}]成功...", msg.getUserName(), msg.getGroupName());
        }
        else {
            logger.info("[{}]加入群聊[{}]失败, 原因[{}]", msg.getUserName(), msg.getGroupName(), msg.getReason());
        }
    }
}
