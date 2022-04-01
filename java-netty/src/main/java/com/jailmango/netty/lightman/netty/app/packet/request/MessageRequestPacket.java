package com.jailmango.netty.lightman.netty.app.packet.request;

import lombok.Data;

import com.jailmango.netty.lightman.netty.app.packet.Packet;
import com.jailmango.netty.lightman.netty.app.packet.command.Command;

/**
 * MessageRequestPacket
 *
 * @author jailmango
 * @CreateDate 2019/9/3
 * @see com.jailmango.netty.lightman.netty.app.packet.request
 * @since R9.0
 */
@Data
public class MessageRequestPacket extends Packet {

    /**
     * toUserName
     */
    private String toUserName;

    /**
     * message
     */
    private String message;

    /**
     * Constructor
     * 
     * @param toUserName String
     * @param message String
     */
    public MessageRequestPacket(String toUserName, String message) {
        this.toUserName = toUserName;
        this.message = message;
    }

    @Override
    public Byte getCommand() {
        return Command.MESSAGE_REQUEST;
    }
}
