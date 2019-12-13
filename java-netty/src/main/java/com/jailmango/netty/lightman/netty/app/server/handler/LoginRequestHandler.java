package com.jailmango.netty.lightman.netty.app.server.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import com.jailmango.netty.lightman.netty.app.packet.request.LoginRequestPacket;
import com.jailmango.netty.lightman.netty.app.packet.response.LoginResponsePacket;
import com.jailmango.netty.lightman.netty.app.session.Session;
import com.jailmango.netty.lightman.netty.app.util.IDUtil;
import com.jailmango.netty.lightman.netty.app.util.SessionUtil;

/**
 * LoginRequestHandler
 *
 * @author he.gang33
 * @CreateDate 2019/9/11
 * @see com.jailmango.netty.lightman.netty.app.server.handler
 * @since R9.0
 */
@ChannelHandler.Sharable
public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(LoginRequestHandler.class);

    /**
     * instance
     */
    public static final LoginRequestHandler INSTANCE = new LoginRequestHandler();

    /**
     * Constructor
     */
    private LoginRequestHandler() {

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestPacket loginRequestPacket) throws Exception {
        logger.info("开始处理登陆请求...");

        LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
        loginResponsePacket.setVersion(loginRequestPacket.getVersion());
        loginResponsePacket.setUserName(loginRequestPacket.getUserName());

        if (validate(loginRequestPacket)) {
            String userId = IDUtil.generateID();
            loginResponsePacket.setUserId(userId);
            loginResponsePacket.setSuccess(true);

            SessionUtil.bindSession(new Session(userId, loginRequestPacket.getUserName()), ctx.channel());

            logger.info("{}[{}]登录成功...", loginRequestPacket.getUserName(), userId);
        }
        else {
            loginResponsePacket.setSuccess(false);
            loginResponsePacket.setReason("用户名密码校验失败...");
            logger.info("{}登录失败...", loginRequestPacket.getUserName());
        }

        ctx.channel().writeAndFlush(loginResponsePacket);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        SessionUtil.unbindSession(ctx.channel());
    }

    /**
     * 校验用户名密码
     * 
     * @param loginRequestPacket LoginRequestPacket
     * @return boolean
     */
    private boolean validate(LoginRequestPacket loginRequestPacket) {
        return true;
    }
}
