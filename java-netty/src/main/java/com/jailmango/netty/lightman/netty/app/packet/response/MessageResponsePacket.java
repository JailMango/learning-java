package com.jailmango.netty.lightman.netty.app.packet.response;

import lombok.Data;

import com.jailmango.netty.lightman.netty.app.packet.Packet;
import com.jailmango.netty.lightman.netty.app.packet.command.Command;

/**
 * MessageResponsePacket
 *
 * @author jailmango
 * @CreateDate 2019/9/3
 * @see com.jailmango.netty.lightman.netty.app.packet.response
 * @since R9.0
 */
@Data
public class MessageResponsePacket extends Packet {

    /**
     * fromUserId
     */
    private String fromUserId;

    /**
     * fromUserName
     */
    private String fromUserName;

    /**
     * message
     */
    private String message;

    @Override
    public Byte getCommand() {
        return Command.MESSAGE_RESPONSE;
    }
}
