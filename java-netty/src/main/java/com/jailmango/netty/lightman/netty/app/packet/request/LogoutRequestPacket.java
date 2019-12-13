package com.jailmango.netty.lightman.netty.app.packet.request;

import lombok.Data;

import com.jailmango.netty.lightman.netty.app.packet.Packet;
import com.jailmango.netty.lightman.netty.app.packet.command.Command;

/**
 * LogoutRequestPacket
 *
 * @author he.gang33
 * @CreateDate 2019/9/26
 * @see com.jailmango.netty.lightman.netty.app.packet.request
 * @since R9.0
 */
@Data
public class LogoutRequestPacket extends Packet {

    @Override
    public Byte getCommand() {
        return Command.LOGOUT_REQUEST;
    }
}
