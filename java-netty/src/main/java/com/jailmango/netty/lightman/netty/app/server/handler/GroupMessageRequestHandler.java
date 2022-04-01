package com.jailmango.netty.lightman.netty.app.server.handler;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;

import com.jailmango.netty.lightman.netty.app.packet.request.GroupMessageRequestPacket;
import com.jailmango.netty.lightman.netty.app.packet.response.GroupMessageResponsePacket;
import com.jailmango.netty.lightman.netty.app.packet.response.MessageResponsePacket;
import com.jailmango.netty.lightman.netty.app.session.Session;
import com.jailmango.netty.lightman.netty.app.util.SessionUtil;

/**
 * GroupMessageRequestHandler
 *
 * @author jailmango
 * @CreateDate 2019/12/5
 * @see com.jailmango.netty.lightman.netty.app.server.handler
 * @since R9.0
 */
@ChannelHandler.Sharable
public class GroupMessageRequestHandler extends SimpleChannelInboundHandler<GroupMessageRequestPacket> {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(GroupMessageRequestHandler.class);

    /**
     * instance
     */
    public static final GroupMessageRequestHandler INSTANCE = new GroupMessageRequestHandler();

    /**
     * Constructor
     */
    private GroupMessageRequestHandler() {

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GroupMessageRequestPacket msg) throws Exception {
        logger.info("开始处理群聊消息请求...");

        String groupName = msg.getToGroupName();
        String groupId = SessionUtil.getGroupId(groupName);

        if (StringUtils.isBlank(groupId)) {
            logger.info("发送失败, 群聊[{}]不存在...", groupName);

            MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
            messageResponsePacket.setMessage("发送失败, 群聊[" + groupName + "]不存在");
            messageResponsePacket.setFromUserName("服务器");

            ctx.channel().writeAndFlush(messageResponsePacket);
        }
        else {
            Session session = SessionUtil.getSession(ctx.channel());
            String fromUserName = session.getUserName();

            GroupMessageResponsePacket groupMessageResponsePacket = new GroupMessageResponsePacket();
            groupMessageResponsePacket.setFromUserName(fromUserName);
            groupMessageResponsePacket.setFromGroupName(groupName);
            groupMessageResponsePacket.setMessage(msg.getMessage());

            ChannelGroup channelGroup = SessionUtil.getChannelGroup(groupId);
            channelGroup.writeAndFlush(groupMessageResponsePacket);
        }
    }
}
