package com.jailmango.netty.lightman.netty.app.client.console.impl;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.Channel;

import com.jailmango.netty.lightman.netty.app.client.console.ConsoleCommand;
import com.jailmango.netty.lightman.netty.app.packet.request.MessageRequestPacket;

/**
 * SendToUserCommand
 *
 * @author he.gang33
 * @CreateDate 2019/9/26
 * @see com.jailmango.netty.lightman.netty.app.client.console.impl
 * @since R9.0
 */
public class SendToUserConsoleCommand implements ConsoleCommand {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(SendToUserConsoleCommand.class);

    @Override
    public void execute(Scanner scanner, Channel channel) {
        logger.info("输入收件人名称:");
        String toUserName = scanner.nextLine();
        logger.info("输入信息内容:");
        String message = scanner.nextLine();

        channel.writeAndFlush(new MessageRequestPacket(toUserName, message));
    }
}
