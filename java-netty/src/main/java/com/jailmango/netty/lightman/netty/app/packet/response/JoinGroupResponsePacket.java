package com.jailmango.netty.lightman.netty.app.packet.response;

import lombok.Data;

import com.jailmango.netty.lightman.netty.app.packet.Packet;
import com.jailmango.netty.lightman.netty.app.packet.command.Command;

/**
 * JoinGroupResponsePacket
 *
 * @author jailmango
 * @CreateDate 2019/11/21
 * @see com.jailmango.netty.lightman.netty.app.packet.response
 * @since R9.0
 */
@Data
public class JoinGroupResponsePacket extends Packet {

    /**
     * groupId
     */
    private String groupId;

    /**
     * groupName
     */
    private String groupName;

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
        return Command.JOIN_GROUP_RESPONSE;
    }
}
