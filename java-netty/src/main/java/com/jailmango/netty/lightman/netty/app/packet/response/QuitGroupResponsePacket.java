package com.jailmango.netty.lightman.netty.app.packet.response;

import lombok.Data;

import com.jailmango.netty.lightman.netty.app.packet.Packet;
import com.jailmango.netty.lightman.netty.app.packet.command.Command;

/**
 * QuitGroupResponsePacket
 *
 * @author he.gang33
 * @CreateDate 2019/11/22
 * @see com.jailmango.netty.lightman.netty.app.packet.response
 * @since R9.0
 */
@Data
public class QuitGroupResponsePacket extends Packet {

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
        return Command.QUIT_GROUP_RESPONSE;
    }

    public String getGroupName() {
        return groupName;
    }
}
