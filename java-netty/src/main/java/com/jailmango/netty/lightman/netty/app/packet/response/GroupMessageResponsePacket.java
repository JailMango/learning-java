package com.jailmango.netty.lightman.netty.app.packet.response;

import lombok.Data;

import com.jailmango.netty.lightman.netty.app.packet.Packet;
import com.jailmango.netty.lightman.netty.app.packet.command.Command;

/**
 * GroupMessageResponsePacket
 *
 * @author jailmango
 * @CreateDate 2019/12/5
 * @see com.jailmango.netty.lightman.netty.app.packet.response
 * @since R9.0
 */
@Data
public class GroupMessageResponsePacket extends Packet {

    /**
     * fromGroupName
     */
    private String fromGroupName;

    /**
     * fromUserName
     */
    private String fromUserName;

    /**
     * message
     */
    private String message;

    @Override
    public Byte getCommand() {
        return Command.GROUP_MESSAGE_RESPONSE;
    }
}
