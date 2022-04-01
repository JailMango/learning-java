package com.jailmango.netty.lightman.netty.chat.server.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import com.jailmango.netty.lightman.netty.chat.packet.request.LoginRequestPacket;
import com.jailmango.netty.lightman.netty.chat.packet.response.LoginResponsePacket;
import com.jailmango.netty.lightman.netty.chat.util.LoginUtil;

/**
 * LoginRequestHandler
 *
 * @author jailmango
 * @CreateDate 2019-08-12
 * @see com.jailmango.netty.lightman.netty.chat.server.handler
 * @since R9.0
 */
public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(LoginRequestHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestPacket msg) throws Exception {
        logger.info("Netty Server receive login command...");

        LoginResponsePacket responsePacket = new LoginResponsePacket();
        responsePacket.setVersion(msg.getVersion());

        if (valid(msg)) {
            responsePacket.setSuccess(true);
            LoginUtil.markAsLogin(ctx.channel());
            logger.info("Login Success...");
        }
        else {
            responsePacket.setSuccess(false);
            responsePacket.setReason("Invalid username and password...");
            logger.info("Login failed...");
        }

        ctx.channel().writeAndFlush(responsePacket);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        logger.info("channelReadComplete -> channel某次数据读完");
        super.channelReadComplete(ctx);
    }

    /**
     * valid
     *
     * @param packet LoginRequestPacket
     * @return boolean
     */
    private boolean valid(LoginRequestPacket packet) {
        return "jailmango".equals(packet.getUsername()) && "password".equals(packet.getPassword());
    }
}
