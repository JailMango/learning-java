package com.jailmango.netty.lightman.netty.app.client.console.impl;

import java.util.Arrays;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jailmango.netty.lightman.netty.app.client.console.ConsoleCommand;
import com.jailmango.netty.lightman.netty.app.packet.request.CreateGroupRequestPacket;
import io.netty.channel.Channel;

/**
 * CreateGroupConsoleCommand
 *
 * @author jailmango
 * @CreateDate 2019/9/26
 * @see com.jailmango.netty.lightman.netty.app.client.console.impl
 * @since R9.0
 */
public class CreateGroupConsoleCommand implements ConsoleCommand {
    
    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(CreateGroupConsoleCommand.class);

    /**
     * 分隔符
     */
    private static final String SPLITER = ",";
    

    @Override
    public void execute(Scanner scanner, Channel channel) {
        CreateGroupRequestPacket requestPacket = new CreateGroupRequestPacket();

        logger.info("输入群聊名称:");
        String groupName = scanner.nextLine();
        requestPacket.setGroupName(groupName);

        logger.info("输入拉入群聊的用户:");
        String users = scanner.nextLine();
        requestPacket.setUserNameList(Arrays.asList(users.split(SPLITER)));

        channel.writeAndFlush(requestPacket);
    }
}
