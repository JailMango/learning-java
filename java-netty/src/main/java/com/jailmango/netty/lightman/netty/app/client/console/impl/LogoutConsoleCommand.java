package com.jailmango.netty.lightman.netty.app.client.console.impl;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jailmango.netty.lightman.netty.app.client.console.ConsoleCommand;
import com.jailmango.netty.lightman.netty.app.packet.request.LogoutRequestPacket;
import io.netty.channel.Channel;

/**
 * LogoutConsoleCommand
 *
 * @author he.gang33
 * @CreateDate 2019/9/26
 * @see com.jailmango.netty.lightman.netty.app.client.console.impl
 * @since R9.0
 */
public class LogoutConsoleCommand implements ConsoleCommand {
    
    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(LogoutConsoleCommand.class);

    @Override
    public void execute(Scanner scanner, Channel channel) {
        LogoutRequestPacket requestPacket = new LogoutRequestPacket();
        channel.writeAndFlush(requestPacket);
    }
}
