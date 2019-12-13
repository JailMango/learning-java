package com.jailmango.netty.lightman.netty.chat.packet.response;

import lombok.Data;

import com.jailmango.netty.lightman.netty.chat.packet.Command;
import com.jailmango.netty.lightman.netty.chat.packet.Packet;

/**
 * LoginResponsePacket
 *
 * @author he.gang33
 * @CreateDate 2019-08-08
 * @see com.jailmango.netty.lightman.netty.chat.packet
 * @since R9.0
 */
@Data
public class LoginResponsePacket extends Packet {

    /**
     * success
     */
    private boolean success;

    /**
     * reason
     */
    private String reason;

    @Override
    public Byte getCommand() {
        return Command.LOGIN_RESPONSE;
    }
}
