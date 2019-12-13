package com.jailmango.netty.lightman.netty.app.packet.request;

import lombok.Data;

import com.jailmango.netty.lightman.netty.app.packet.Packet;
import com.jailmango.netty.lightman.netty.app.packet.command.Command;

/**
 * GroupMessageRequestPacket
 *
 * @author he.gang33
 * @CreateDate 2019/12/5
 * @see com.jailmango.netty.lightman.netty.app.packet.request
 * @since R9.0
 */
@Data
public class GroupMessageRequestPacket extends Packet {

    /**
     * toGroupName
     */
    private String toGroupName;

    /**
     * message
     */
    private String message;

    @Override
    public Byte getCommand() {
        return Command.GROUP_MESSAGE_REQUEST;
    }
}
