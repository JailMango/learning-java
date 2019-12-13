package com.jailmango.netty.lightman.netty.app.client.handler;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import com.jailmango.netty.lightman.netty.app.packet.response.ListGroupMembersResposnePacket;
import com.jailmango.netty.lightman.netty.app.session.Session;

/**
 * ListGroupMembersResponseHandler
 *
 * @author he.gang33
 * @CreateDate 2019/11/25
 * @see com.jailmango.netty.lightman.netty.app.client.handler
 * @since R9.0
 */
public class ListGroupMembersResponseHandler extends SimpleChannelInboundHandler<ListGroupMembersResposnePacket> {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ListGroupMembersResponseHandler.class);

    /**
     * comma
     */
    private static final String COMMA = ",";

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ListGroupMembersResposnePacket msg) throws Exception {
        String groupName = msg.getGroupName();

        if (msg.isSuccess()) {
            List<Session> sessionList = msg.getSessionList();

            if (CollectionUtils.isNotEmpty(sessionList)) {
                StringBuilder sb = new StringBuilder();

                for (Session session : sessionList) {
                    sb.append(session.getUserName()).append(COMMA);
                }

                sb.deleteCharAt(sb.length() - 1);

                logger.info("查询群聊[{}]成员:[{}]", groupName, sb.toString());
            }
        }
        else {
            logger.info("查询群聊[{}]成员失败, 原因:[{}]...", groupName, msg.getReason());
        }
    }
}
