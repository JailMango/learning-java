package com.jailmango.netty.lightman.netty.app.packet.response;

import lombok.Data;

import com.jailmango.netty.lightman.netty.app.packet.Packet;
import com.jailmango.netty.lightman.netty.app.packet.command.Command;

/**
 * LoginResponsePacket
 *
 * @author he.gang33
 * @CreateDate 2019/9/3
 * @see com.jailmango.netty.lightman.netty.app.packet.response
 * @since R9.0
 */
@Data
public class LoginResponsePacket extends Packet {

    /**
     * userId
     */
    private String userId;

    /**
     * userName
     */
    private String userName;

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
