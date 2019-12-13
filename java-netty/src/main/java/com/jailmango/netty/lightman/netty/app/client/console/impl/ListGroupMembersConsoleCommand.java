package com.jailmango.netty.lightman.netty.app.client.console.impl;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.Channel;

import com.jailmango.netty.lightman.netty.app.client.console.ConsoleCommand;
import com.jailmango.netty.lightman.netty.app.packet.request.ListGroupMembersRequestPacket;

/**
 * ListGroupMembersConsoleCommand
 *
 * @author he.gang33
 * @CreateDate 2019/11/25
 * @see com.jailmango.netty.lightman.netty.app.client.console.impl
 * @since R9.0
 */
public class ListGroupMembersConsoleCommand implements ConsoleCommand {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ListGroupMembersConsoleCommand.class);

    @Override
    public void execute(Scanner scanner, Channel channel) {
        ListGroupMembersRequestPacket requestPacket = new ListGroupMembersRequestPacket();

        logger.info("输入群聊名称:");
        String groupName = scanner.nextLine();
        requestPacket.setGroupName(groupName);

        channel.writeAndFlush(requestPacket);
    }
}
