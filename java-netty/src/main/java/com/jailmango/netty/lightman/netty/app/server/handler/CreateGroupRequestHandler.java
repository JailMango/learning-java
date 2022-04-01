package com.jailmango.netty.lightman.netty.app.server.handler;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;

import com.jailmango.netty.lightman.netty.app.packet.request.CreateGroupRequestPacket;
import com.jailmango.netty.lightman.netty.app.packet.response.CreateGroupResponsePacket;
import com.jailmango.netty.lightman.netty.app.session.Session;
import com.jailmango.netty.lightman.netty.app.util.IDUtil;
import com.jailmango.netty.lightman.netty.app.util.SessionUtil;

/**
 * CreateGroupRequestHandler
 *
 * @author jailmango
 * @CreateDate 2019/10/8
 * @see com.jailmango.netty.lightman.netty.app.server.handler
 * @since R9.0
 */
@ChannelHandler.Sharable
public class CreateGroupRequestHandler extends SimpleChannelInboundHandler<CreateGroupRequestPacket> {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(CreateGroupRequestHandler.class);

    /**
     * instance
     */
    public static final CreateGroupRequestHandler INSTANCE = new CreateGroupRequestHandler();

    /**
     * Constructor
     */
    private CreateGroupRequestHandler() {

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, CreateGroupRequestPacket msg) throws Exception {
        String groupName = msg.getGroupName();
        String groupId = SessionUtil.getGroupId(groupName);

        CreateGroupResponsePacket responsePacket = new CreateGroupResponsePacket();
        responsePacket.setGroupName(groupName);

        if (StringUtils.isNotBlank(groupId)) {
            responsePacket.setSuccess(false);
            logger.info("创建群聊[{}]失败, 原因[{}]...", groupName, "群聊已存在");

            ctx.channel().writeAndFlush(responsePacket);
        }
        else {
            // 1. 创建一个分组
            ChannelGroup channelGroup = new DefaultChannelGroup(ctx.executor());
            List<String> userNameList = msg.getUserNameList();
            Channel channel;

            // 2. 筛选出带加入群聊的channel，将其加入分组
            if (CollectionUtils.isNotEmpty(userNameList)) {
                // 3. 获取发送请求的用户
                Session session = SessionUtil.getSession(ctx.channel());
                userNameList.add(session.getUserName());

                for (String userName : userNameList) {
                    channel = SessionUtil.getChannel(SessionUtil.getUserId(userName));

                    if (null != channel) {
                        channelGroup.add(channel);
                    }
                }

                channelGroup.add(ctx.channel());
            }

            groupId = IDUtil.generateID();
            responsePacket.setGroupId(groupId);
            responsePacket.setUserNameList(userNameList);
            responsePacket.setSuccess(true);

            // 3. 广播通知
            channelGroup.writeAndFlush(responsePacket);

            logger.info("创建群聊{}[{}]成功...", groupName, groupId);
            logger.info("群成员:[{}]", userNameList);

            SessionUtil.bindChannelGroup(groupName, groupId, channelGroup);
        }
    }
}
