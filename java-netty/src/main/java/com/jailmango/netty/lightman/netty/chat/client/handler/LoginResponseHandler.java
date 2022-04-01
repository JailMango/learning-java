package com.jailmango.netty.lightman.netty.chat.client.handler;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import com.jailmango.netty.lightman.netty.chat.packet.request.LoginRequestPacket;
import com.jailmango.netty.lightman.netty.chat.packet.response.LoginResponsePacket;
import com.jailmango.netty.lightman.netty.chat.util.LoginUtil;

/**
 * LoginResponseHandler
 *
 * @author jailmango
 * @CreateDate 2019-08-12
 * @see com.jailmango.netty.lightman.netty.chat.client.handler
 * @since R9.0
 */
public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginResponsePacket> {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(LoginResponseHandler.class);

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        logger.info("Netty Client login...");

        LoginRequestPacket packet = new LoginRequestPacket();
        packet.setId(UUID.randomUUID().toString());
        packet.setUsername("jailmango");
        packet.setPassword("password");

        ctx.channel().writeAndFlush(packet);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginResponsePacket msg) throws Exception {
        if (msg.isSuccess()) {
            LoginUtil.markAsLogin(ctx.channel());
            logger.info("Login success...");
        }
        else {
            logger.info("Login failed...");
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        logger.info("Channel close...");
    }
}
