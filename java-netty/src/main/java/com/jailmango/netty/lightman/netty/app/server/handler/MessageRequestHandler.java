package com.jailmango.netty.lightman.netty.app.server.handler;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import com.jailmango.netty.lightman.netty.app.packet.request.MessageRequestPacket;
import com.jailmango.netty.lightman.netty.app.packet.response.MessageResponsePacket;
import com.jailmango.netty.lightman.netty.app.session.Session;
import com.jailmango.netty.lightman.netty.app.util.SessionUtil;

/**
 * MessageRequestHandler
 *
 * @author he.gang33
 * @CreateDate 2019/9/19
 * @see com.jailmango.netty.lightman.netty.app.server.handler
 * @since R9.0
 */
@ChannelHandler.Sharable
public class MessageRequestHandler extends SimpleChannelInboundHandler<MessageRequestPacket> {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(MessageRequestHandler.class);

    /**
     * instance
     */
    public static final MessageRequestHandler INSTANCE = new MessageRequestHandler();

    /**
     * Constructor
     */
    private MessageRequestHandler() {

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageRequestPacket msg) throws Exception {
        Session session = SessionUtil.getSession(ctx.channel());

        String fromUserId = session.getUserId();
        String fromUserName = session.getUserName();
        String toUserName = msg.getToUserName();
        String toUserId = SessionUtil.getUserId(toUserName);

        MessageResponsePacket messageResponsePacket = new MessageResponsePacket();

        if (StringUtils.isNotBlank(toUserId)) {
            messageResponsePacket.setFromUserId(fromUserId);
            messageResponsePacket.setFromUserName(fromUserName);
            messageResponsePacket.setMessage(msg.getMessage());

            Channel toChannel = SessionUtil.getChannel(toUserId);
            toChannel.writeAndFlush(messageResponsePacket);
        }
        else {
            logger.info("发送失败, {}不在线", toUserName);
            messageResponsePacket.setFromUserId("服务器ID-1");
            messageResponsePacket.setFromUserName("服务器");
            messageResponsePacket.setMessage("发送失败, " + toUserName + "不在线");
            // ctx.channel().writeAndFlush(messageResponsePacket);
            // 从当前节点开始往前找OutBound类型的handler(即编解码handler)，而非从链表起始位置开始
            ctx.writeAndFlush(messageResponsePacket);
        }
    }
}
