package com.jailmango.netty.lightman.netty.app.server.handler;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;

import com.jailmango.netty.lightman.netty.app.packet.request.ListGroupMembersRequestPacket;
import com.jailmango.netty.lightman.netty.app.packet.response.ListGroupMembersResposnePacket;
import com.jailmango.netty.lightman.netty.app.session.Session;
import com.jailmango.netty.lightman.netty.app.util.SessionUtil;

/**
 * ListGroupMembersRequestHandler
 *
 * @author he.gang33
 * @CreateDate 2019/11/25
 * @see com.jailmango.netty.lightman.netty.app.server.handler
 * @since R9.0
 */
@ChannelHandler.Sharable
public class ListGroupMembersRequestHandler extends SimpleChannelInboundHandler<ListGroupMembersRequestPacket> {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ListGroupMembersRequestHandler.class);

    /**
     * instance
     */
    public static final ListGroupMembersRequestHandler INSTANCE = new ListGroupMembersRequestHandler();

    /**
     * Constructor
     */
    private ListGroupMembersRequestHandler() {

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ListGroupMembersRequestPacket msg) throws Exception {
        logger.info("开始处理查询群聊成员请求...");

        String groupName = msg.getGroupName();
        String groupId = SessionUtil.getGroupId(groupName);

        ListGroupMembersResposnePacket responsePacket = new ListGroupMembersResposnePacket();
        responsePacket.setGroupName(groupName);

        if (StringUtils.isBlank(groupId)) {
            responsePacket.setSuccess(false);
            responsePacket.setReason("群聊不存在");
            logger.info("查询群聊[{}]成员失败, 原因: 群聊不存在...", groupName);
        }
        else {
            responsePacket.setSuccess(true);
            List<Session> sessionList = new ArrayList<>();
            ChannelGroup channelGroup = SessionUtil.getChannelGroup(groupId);

            for (Channel channel : channelGroup) {
                sessionList.add(SessionUtil.getSession(channel));
            }

            responsePacket.setSessionList(sessionList);
        }

        ctx.channel().writeAndFlush(responsePacket);
    }
}
