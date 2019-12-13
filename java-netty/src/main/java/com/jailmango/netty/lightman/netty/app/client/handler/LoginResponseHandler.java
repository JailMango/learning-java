package com.jailmango.netty.lightman.netty.app.client.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import com.jailmango.netty.lightman.netty.app.packet.response.LoginResponsePacket;
import com.jailmango.netty.lightman.netty.app.session.Session;
import com.jailmango.netty.lightman.netty.app.util.SessionUtil;

/**
 * LoginResponseHandler
 *
 * @author he.gang33
 * @CreateDate 2019/9/17
 * @see com.jailmango.netty.lightman.netty.app.client.handler
 * @since R9.0
 */
public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginResponsePacket> {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(LoginResponseHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginResponsePacket msg) throws Exception {
        String userId = msg.getUserId();
        String userName = msg.getUserName();

        if (msg.isSuccess()) {
            SessionUtil.bindSession(new Session(userId, userName), ctx.channel());
            logger.info("{}[{}]登录成功...", userName, userId);
        }
        else {
            logger.info("{}登录失败, 原因[{}]...", userName, msg.getReason());
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        logger.info("客户端被关闭...");
    }
}
