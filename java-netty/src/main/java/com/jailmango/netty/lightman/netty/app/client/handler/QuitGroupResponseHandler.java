package com.jailmango.netty.lightman.netty.app.client.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import com.jailmango.netty.lightman.netty.app.packet.response.QuitGroupResponsePacket;

/**
 * QuitGroupResponseHandler
 *
 * @author jailmango
 * @CreateDate 2019/11/22
 * @see com.jailmango.netty.lightman.netty.app.client.handler
 * @since R9.0
 */
public class QuitGroupResponseHandler extends SimpleChannelInboundHandler<QuitGroupResponsePacket> {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(QuitGroupResponseHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, QuitGroupResponsePacket msg) throws Exception {
        if (msg.isSuccess()) {
            logger.info("[{}]退出群聊[{}]成功...", msg.getUserName(), msg.getGroupName());
        }
        else {
            logger.info("[{}]退出群聊[{}]失败, 原因[{}]...", msg.getUserName(), msg.getGroupName(), msg.getReason());
        }
    }
}
