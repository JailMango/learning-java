package com.jailmango.netty.lightman.netty.chat.packet.response;

import lombok.Data;

import com.jailmango.netty.lightman.netty.chat.packet.Command;
import com.jailmango.netty.lightman.netty.chat.packet.Packet;

/**
 * MessageResponsePacket
 *
 * @author he.gang33
 * @CreateDate 2019-08-09
 * @see com.jailmango.netty.lightman.netty.chat.packet.response
 * @since R9.0
 */
@Data
public class MessageResponsePacket extends Packet {

    /**
     * message
     */
    private String message;

    @Override
    public Byte getCommand() {
        return Command.MESSAGE_RESPONSE;
    }
}
