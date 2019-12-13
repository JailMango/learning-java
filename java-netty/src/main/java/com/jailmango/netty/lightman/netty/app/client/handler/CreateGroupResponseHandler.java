package com.jailmango.netty.lightman.netty.app.client.handler;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import com.jailmango.netty.lightman.netty.app.packet.response.CreateGroupResponsePacket;
import com.jailmango.netty.lightman.netty.app.util.SessionUtil;

/**
 * CreateGroupResponseHandler
 *
 * @author he.gang33
 * @CreateDate 2019/10/8
 * @see com.jailmango.netty.lightman.netty.app.client.handler
 * @since R9.0
 */
public class CreateGroupResponseHandler extends SimpleChannelInboundHandler<CreateGroupResponsePacket> {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(CreateGroupResponseHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, CreateGroupResponsePacket msg) throws Exception {
        if (msg.isSuccess()) {
            String currentUserName = SessionUtil.getSession(ctx.channel()).getUserName();
            List<String> userNameList = msg.getUserNameList();

            if (CollectionUtils.isNotEmpty(userNameList)) {
                for (int index = userNameList.size(); index > 0; index--) {
                    if (currentUserName.equalsIgnoreCase(userNameList.get(index - 1))) {
                        userNameList.remove(index - 1);
                    }
                }
            }

            logger.info("已加入群聊{}[{}]", msg.getGroupName(), msg.getGroupId());
            logger.info("群成员:[{}]", msg.getUserNameList());
        }
        else {
            logger.info("创建群聊[{}]失败...", msg.getGroupName());
        }
    }
}
