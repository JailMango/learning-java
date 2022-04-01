package com.jailmango.netty.lightman.netty.app.server.handler;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;

import com.jailmango.netty.lightman.netty.app.packet.request.JoinGroupRequestPacket;
import com.jailmango.netty.lightman.netty.app.packet.response.JoinGroupResponsePacket;
import com.jailmango.netty.lightman.netty.app.util.SessionUtil;

/**
 * JoinGroupRequestHandler
 *
 * @author jailmango
 * @CreateDate 2019/11/21
 * @see com.jailmango.netty.lightman.netty.app.server.handler
 * @since R9.0
 */
@ChannelHandler.Sharable
public class JoinGroupRequestHandler extends SimpleChannelInboundHandler<JoinGroupRequestPacket> {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(JoinGroupRequestHandler.class);

    /**
     * instance
     */
    public static final JoinGroupRequestHandler INSTANCE = new JoinGroupRequestHandler();

    /**
     * Constructor
     */
    private JoinGroupRequestHandler() {

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, JoinGroupRequestPacket msg) throws Exception {
        logger.info("开始处理加入群聊请求...");
        String groupName = msg.getGroupName();
        String groupId = SessionUtil.getGroupId(groupName);
        String userName = SessionUtil.getSession(ctx.channel()).getUserName();

        JoinGroupResponsePacket responsePacket = new JoinGroupResponsePacket();
        responsePacket.setGroupName(groupName);
        responsePacket.setUserName(userName);

        if (StringUtils.isNotBlank(groupId)) {
            responsePacket.setSuccess(true);
            responsePacket.setGroupId(groupId);

            ChannelGroup channelGroup = SessionUtil.getChannelGroup(groupId);
            channelGroup.add(ctx.channel());
            channelGroup.writeAndFlush(responsePacket);

            logger.info("[{}]加入群聊[{}]...", SessionUtil.getSession(ctx.channel()).getUserName(), groupName);
        }
        else {
            responsePacket.setSuccess(false);
            responsePacket.setReason("群聊不存在");
            ctx.channel().writeAndFlush(responsePacket);
            logger.info("[{}]加入群聊[{}]失败, 原因[{}]...", userName, groupName, "群聊不存在");
        }
    }
}
