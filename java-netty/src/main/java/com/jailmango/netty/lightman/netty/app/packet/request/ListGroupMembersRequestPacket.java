package com.jailmango.netty.lightman.netty.app.packet.request;

import lombok.Data;

import com.jailmango.netty.lightman.netty.app.packet.Packet;
import com.jailmango.netty.lightman.netty.app.packet.command.Command;

/**
 * ListGroupMembersRequestPacket
 *
 * @author he.gang33
 * @CreateDate 2019/11/25
 * @see com.jailmango.netty.lightman.netty.app.packet.request
 * @since R9.0
 */
@Data
public class ListGroupMembersRequestPacket extends Packet {

    /**
     * groupName
     */
    private String groupName;

    @Override
    public Byte getCommand() {
        return Command.LIST_GROUP_MEMBERS_REQUEST;
    }
}
