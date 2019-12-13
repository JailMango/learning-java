package com.jailmango.netty.lightman.netty.app.client.console.impl;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.Channel;

import com.jailmango.netty.lightman.netty.app.client.console.ConsoleCommand;
import com.jailmango.netty.lightman.netty.app.packet.request.GroupMessageRequestPacket;

/**
 * SendToGroupCommand
 *
 * @author he.gang33
 * @CreateDate 2019/10/8
 * @see com.jailmango.netty.lightman.netty.app.client.console.impl
 * @since R9.0
 */
public class SendToGroupConsoleCommand implements ConsoleCommand {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(SendToGroupConsoleCommand.class);

    @Override
    public void execute(Scanner scanner, Channel channel) {
        logger.info("输入群聊名称:");
        String groupName = scanner.nextLine();

        logger.info("输入信息内容:");
        String message = scanner.nextLine();

        GroupMessageRequestPacket requestPacket = new GroupMessageRequestPacket();
        requestPacket.setToGroupName(groupName);
        requestPacket.setMessage(message);

        channel.writeAndFlush(requestPacket);

    }
}
