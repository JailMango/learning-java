package com.jailmango.netty.lightman.netty.app.packet.request;

import java.util.List;

import lombok.Data;

import com.jailmango.netty.lightman.netty.app.packet.Packet;
import com.jailmango.netty.lightman.netty.app.packet.command.Command;

/**
 * CreateGroupRequestPacket
 *
 * @author he.gang33
 * @CreateDate 2019/9/26
 * @see com.jailmango.netty.lightman.netty.app.packet.request
 * @since R9.0
 */
@Data
public class CreateGroupRequestPacket extends Packet {

    /**
     * groupName
     */
    private String groupName;

    /**
     * userNameList
     */
    private List<String> userNameList;

    @Override
    public Byte getCommand() {
        return Command.CREATE_GROUP_REQUEST;
    }
}
