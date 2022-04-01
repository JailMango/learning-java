package com.jailmango.netty.lightman.netty.app.packet.response;

import java.util.List;

import lombok.Data;

import com.jailmango.netty.lightman.netty.app.packet.Packet;
import com.jailmango.netty.lightman.netty.app.packet.command.Command;
import com.jailmango.netty.lightman.netty.app.session.Session;

/**
 * ListGroupMembersResposne
 *
 * @author jailmango
 * @CreateDate 2019/11/25
 * @see com.jailmango.netty.lightman.netty.app.packet.response
 * @since R9.0
 */
@Data
public class ListGroupMembersResposnePacket extends Packet {

    /**
     * groupName
     */
    private String groupName;

    /**
     * sessionList
     */
    private List<Session> sessionList;

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
        return Command.LIST_GROUP_MEMBERS_RESPONSE;
    }
}
