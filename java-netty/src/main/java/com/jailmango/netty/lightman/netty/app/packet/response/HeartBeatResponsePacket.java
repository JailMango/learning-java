package com.jailmango.netty.lightman.netty.app.packet.response;

import com.jailmango.netty.lightman.netty.app.packet.Packet;
import com.jailmango.netty.lightman.netty.app.packet.command.Command;

/**
 * HeartBeatResponsePacket
 *
 * @author jailmango
 * @CreateDate 2019/12/16
 * @see com.jailmango.netty.lightman.netty.app.packet.response
 * @since R9.0
 */
public class HeartBeatResponsePacket extends Packet {

    @Override
    public Byte getCommand() {
        return Command.HEART_BEAT_RESPONSE;
    }
}
