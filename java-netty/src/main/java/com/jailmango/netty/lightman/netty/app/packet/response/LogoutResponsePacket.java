package com.jailmango.netty.lightman.netty.app.packet.response;

import com.jailmango.netty.lightman.netty.app.packet.Packet;
import com.jailmango.netty.lightman.netty.app.packet.command.Command;
import lombok.Data;

/**
 * LogoutResponsePacket
 *
 * @author he.gang33
 * @CreateDate 2019/9/26
 * @see com.jailmango.netty.lightman.netty.app.packet.response
 * @since R9.0
 */
@Data
public class LogoutResponsePacket extends Packet {

    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 原因
     */
    private String reason;

    @Override
    public Byte getCommand() {
        return Command.LOGOUT_RESPONSE;
    }
}
