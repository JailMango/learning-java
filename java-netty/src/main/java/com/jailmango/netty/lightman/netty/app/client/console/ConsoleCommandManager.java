package com.jailmango.netty.lightman.netty.app.client.console;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.Channel;

import com.jailmango.netty.lightman.netty.app.client.console.impl.CreateGroupConsoleCommand;
import com.jailmango.netty.lightman.netty.app.client.console.impl.JoinGroupConsoleCommand;
import com.jailmango.netty.lightman.netty.app.client.console.impl.ListGroupMembersConsoleCommand;
import com.jailmango.netty.lightman.netty.app.client.console.impl.LogoutConsoleCommand;
import com.jailmango.netty.lightman.netty.app.client.console.impl.QuitGroupConsoleCommand;
import com.jailmango.netty.lightman.netty.app.client.console.impl.SendToGroupConsoleCommand;
import com.jailmango.netty.lightman.netty.app.client.console.impl.SendToUserConsoleCommand;
import com.jailmango.netty.lightman.netty.app.util.SessionUtil;

/**
 * ConsoleCommandManager
 *
 * @author jailmango
 * @CreateDate 2019/9/25
 * @see com.jailmango.netty.lightman.netty.app.client.console.impl
 * @since R9.0
 */
public class ConsoleCommandManager implements ConsoleCommand {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ConsoleCommandManager.class);

    /**
     * commandMap
     */
    private Map<String, ConsoleCommand> commandMap;

    /**
     * Constructor
     */
    public ConsoleCommandManager() {
        commandMap = new HashMap<>();
        commandMap.put("logout", new LogoutConsoleCommand());
        commandMap.put("sendToUser", new SendToUserConsoleCommand());
        commandMap.put("createGroup", new CreateGroupConsoleCommand());
        commandMap.put("joinGroup", new JoinGroupConsoleCommand());
        commandMap.put("quitGroup", new QuitGroupConsoleCommand());
        commandMap.put("listMembers", new ListGroupMembersConsoleCommand());
        commandMap.put("sendToGroup", new SendToGroupConsoleCommand());
    }

    @Override
    public void execute(Scanner scanner, Channel channel) {
        if (!SessionUtil.hasLogin(channel)) {
            logger.info("尚未登录...");
            return;
        }

        logger.info("请输入指令:");
        String commandName = scanner.nextLine();
        ConsoleCommand consoleCommand = commandMap.get(commandName);

        if (null != consoleCommand) {
            consoleCommand.execute(scanner, channel);
        }
        else {
            logger.info("无法识别指令...");
        }
    }
}
