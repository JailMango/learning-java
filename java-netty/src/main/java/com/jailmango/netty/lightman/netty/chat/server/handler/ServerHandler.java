package com.jailmango.netty.lightman.netty.chat.server.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import com.jailmango.netty.lightman.netty.chat.codec.PacketCodeC;
import com.jailmango.netty.lightman.netty.chat.packet.Packet;
import com.jailmango.netty.lightman.netty.chat.packet.request.LoginRequestPacket;
import com.jailmango.netty.lightman.netty.chat.packet.request.MessageRequestPacket;
import com.jailmango.netty.lightman.netty.chat.packet.response.LoginResponsePacket;
import com.jailmango.netty.lightman.netty.chat.packet.response.MessageResponsePacket;

/**
 * ServerHandler
 *
 * @author he.gang33
 * @CreateDate 2019-08-08
 * @see com.jailmango.netty.lightman.netty.chat.server
 * @since R9.0
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ServerHandler.class);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        logger.info("Netty Server receive...");

        ByteBuf byteBuf = (ByteBuf) msg;
        Packet packet = PacketCodeC.INSTANCE.decode(byteBuf);

        if (packet instanceof LoginRequestPacket) {
            LoginRequestPacket loginRequestPacket = (LoginRequestPacket) packet;

            LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
            loginResponsePacket.setVersion(packet.getVersion());

            if (isValid(loginRequestPacket)) {
                loginResponsePacket.setSuccess(true);
            }
            else {
                loginResponsePacket.setSuccess(false);
                loginResponsePacket.setReason("Invalid username or password...");
            }

            ByteBuf responseByteBuf = PacketCodeC.INSTANCE.encode(ctx.alloc().ioBuffer(), loginResponsePacket);
            ctx.channel().writeAndFlush(responseByteBuf);
        }
        else if (packet instanceof MessageRequestPacket) {
            MessageRequestPacket messageRequestPacket = (MessageRequestPacket) packet;
            logger.info("Server Receive Message: [{}]", messageRequestPacket.getMessage());

            MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
            messageResponsePacket.setVersion(packet.getVersion());
            messageResponsePacket.setMessage(messageRequestPacket.getMessage() + "->response");
            ByteBuf responseByteBuf = PacketCodeC.INSTANCE.encode(ctx.alloc().ioBuffer(), messageResponsePacket);
            ctx.channel().writeAndFlush(responseByteBuf);
        }

    }

    /**
     * isValid
     * 
     * @param packet LoginRequestPacket
     * @return boolean
     */
    private boolean isValid(LoginRequestPacket packet) {
        return "jailmango".equals(packet.getUsername()) && "password".equals(packet.getPassword());
    }
}
