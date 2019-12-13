package com.jailmango.netty.lightman.netty.app.server.handler;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;

import com.jailmango.netty.lightman.netty.app.packet.request.QuitGroupRequestPacket;
import com.jailmango.netty.lightman.netty.app.packet.response.QuitGroupResponsePacket;
import com.jailmango.netty.lightman.netty.app.util.SessionUtil;

/**
 * QuitGroupRequestHandler
 *
 * @author he.gang33
 * @CreateDate 2019/11/22
 * @see com.jailmango.netty.lightman.netty.app.server.handler
 * @since R9.0
 */
@ChannelHandler.Sharable
public class QuitGroupRequestHandler extends SimpleChannelInboundHandler<QuitGroupRequestPacket> {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(QuitGroupRequestPacket.class);

    /**
     * instance
     */
    public static final QuitGroupRequestHandler INSTANCE = new QuitGroupRequestHandler();

    /**
     * Constructor
     */
    private QuitGroupRequestHandler() {

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, QuitGroupRequestPacket msg) throws Exception {
        logger.info("开始处理退出群聊请求...");

        String groupName = msg.getGroupName();
        String groupId = SessionUtil.getGroupId(groupName);
        String userName = SessionUtil.getSession(ctx.channel()).getUserName();

        QuitGroupResponsePacket responsePacket = new QuitGroupResponsePacket();
        responsePacket.setGroupName(groupName);
        responsePacket.setUserName(userName);

        if (StringUtils.isBlank(groupId)) {
            responsePacket.setSuccess(false);
            responsePacket.setReason("群聊不存在");

            logger.info("[{}]退出群聊[{}]失败, 原因[{}]", userName, groupName, responsePacket.getReason());

            ctx.channel().writeAndFlush(responsePacket);
        }
        else {
            ChannelGroup channelGroup = SessionUtil.getChannelGroup(groupId);
            channelGroup.remove(ctx.channel());

            responsePacket.setSuccess(true);
            logger.info("[{}]退出群聊[]成功...", userName, groupName);

            ctx.channel().writeAndFlush(responsePacket);

            if (channelGroup.isEmpty()) {
                SessionUtil.unbindChannelGroup(groupName, groupId);
            }
            else {
                channelGroup.writeAndFlush(responsePacket);
            }
        }
    }
}
