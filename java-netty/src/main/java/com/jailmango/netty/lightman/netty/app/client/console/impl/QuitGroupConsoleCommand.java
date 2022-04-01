package com.jailmango.netty.lightman.netty.app.client.console.impl;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.Channel;

import com.jailmango.netty.lightman.netty.app.client.console.ConsoleCommand;
import com.jailmango.netty.lightman.netty.app.packet.request.QuitGroupRequestPacket;

/**
 * QuitGroupConsoleCommand
 *
 * @author jailmango
 * @CreateDate 2019/11/22
 * @see com.jailmango.netty.lightman.netty.app.client.console.impl
 * @since R9.0
 */
public class QuitGroupConsoleCommand implements ConsoleCommand {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(QuitGroupConsoleCommand.class);

    @Override
    public void execute(Scanner scanner, Channel channel) {
        logger.info("输入群聊名称:");
        String groupName = scanner.nextLine();

        QuitGroupRequestPacket requestPacket = new QuitGroupRequestPacket();
        requestPacket.setGroupName(groupName);

        channel.writeAndFlush(requestPacket);
    }
}
