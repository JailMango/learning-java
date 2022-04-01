package com.jailmango.netty.lightman.netty.chat.client.handler;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import com.jailmango.netty.lightman.netty.chat.packet.Packet;
import com.jailmango.netty.lightman.netty.chat.codec.PacketCodeC;
import com.jailmango.netty.lightman.netty.chat.packet.request.LoginRequestPacket;
import com.jailmango.netty.lightman.netty.chat.packet.response.LoginResponsePacket;
import com.jailmango.netty.lightman.netty.chat.packet.response.MessageResponsePacket;
import com.jailmango.netty.lightman.netty.chat.util.LoginUtil;

/**
 * ClientHandler
 *
 * @author jailmango
 * @CreateDate 2019-08-08
 * @see com.jailmango.netty.lightman.netty.chat.client
 * @since R9.0
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ClientHandler.class);

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        logger.info("Netty Client send...");

        LoginRequestPacket packet = new LoginRequestPacket();
        packet.setId(UUID.randomUUID().toString());
        packet.setUsername("jailmango");
        packet.setPassword("password");

        ByteBuf byteBuf = PacketCodeC.INSTANCE.encode(ctx.alloc().ioBuffer(), packet);

        ctx.channel().writeAndFlush(byteBuf);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        logger.info("Netty Client receive");

        ByteBuf byteBuf = (ByteBuf) msg;
        Packet packet = PacketCodeC.INSTANCE.decode(byteBuf);

        if (packet instanceof LoginResponsePacket) {
            LoginResponsePacket loginResponsePacket = (LoginResponsePacket) packet;

            if (loginResponsePacket.isSuccess()) {
                LoginUtil.markAsLogin(ctx.channel());
                logger.info("Success...");
            }
            else {
                logger.info("Fail... Reason: [{}]", loginResponsePacket.getReason());
            }
        }
        else if (packet instanceof MessageResponsePacket) {
            MessageResponsePacket messageResponsePacket = (MessageResponsePacket) packet;
            logger.info("Client Receive Message: [{}]", messageResponsePacket.getMessage());
        }
    }
}
