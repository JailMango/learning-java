package com.jailmango.netty.lightman.netty.app.packet.request;

import lombok.Data;

import com.jailmango.netty.lightman.netty.app.packet.Packet;
import com.jailmango.netty.lightman.netty.app.packet.command.Command;

/**
 * LoginRequestPacket
 *
 * @author he.gang33
 * @CreateDate 2019/9/3
 * @see com.jailmango.netty.lightman.netty.app.packet.request
 * @since R9.0
 */
@Data
public class LoginRequestPacket extends Packet {

    /**
     * userName
     */
    private String userName;

    /**
     * password
     */
    private String password;

    @Override
    public Byte getCommand() {
        return Command.LOGIN_REQUEST;
    }
}
