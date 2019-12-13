package com.jailmango.netty.lightman.netty.chat.packet.request;

import lombok.Data;

import com.jailmango.netty.lightman.netty.chat.packet.Command;
import com.jailmango.netty.lightman.netty.chat.packet.Packet;

/**
 * LoginRequestPacket
 *
 * @author he.gang33
 * @CreateDate 2019-08-05
 * @see com.jailmango.netty.lightman.netty
 * @since R9.0
 */
@Data
public class LoginRequestPacket extends Packet {

    /**
     * id
     */
    private String id;

    /**
     * username
     */
    private String username;

    /**
     * password
     */
    private String password;

    @Override
    public Byte getCommand() {
        return Command.LOGIN_REQUEST;
    }
}
