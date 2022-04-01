package com.jailmango.netty.lightman.netty.app.packet.request;

import com.jailmango.netty.lightman.netty.app.packet.Packet;
import com.jailmango.netty.lightman.netty.app.packet.command.Command;

/**
 * HeartBeatRequestPacket
 *
 * @author jailmango
 * @CreateDate 2019/12/16
 * @see com.jailmango.netty.lightman.netty.app.packet.request
 * @since R9.0
 */
public class HeartBeatRequestPacket extends Packet {

    @Override
    public Byte getCommand() {
        return Command.HEART_BEAT_REQUEST;
    }
}
