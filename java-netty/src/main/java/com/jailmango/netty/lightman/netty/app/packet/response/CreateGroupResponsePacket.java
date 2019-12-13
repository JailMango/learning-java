package com.jailmango.netty.lightman.netty.app.packet.response;

import java.util.List;

import lombok.Data;

import com.jailmango.netty.lightman.netty.app.packet.Packet;
import com.jailmango.netty.lightman.netty.app.packet.command.Command;

/**
 * CreateGroupResponsePacket
 *
 * @author he.gang33
 * @CreateDate 2019/9/26
 * @see com.jailmango.netty.lightman.netty.app.packet.response
 * @since R9.0
 */
@Data
public class CreateGroupResponsePacket extends Packet {

    /**
     * groupId
     */
    private String groupId;

    /**
     * groupName
     */
    private String groupName;

    /**
     * userIdList
     */
    private List<String> userNameList;

    /**
     * success
     */
    private boolean success;

    @Override
    public Byte getCommand() {
        return Command.CREATE_GROUP_RESPONSE;
    }
}
