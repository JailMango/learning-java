package com.jailmango.netty.lightman.netty.app.client.console.impl;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.Channel;

import com.jailmango.netty.lightman.netty.app.client.console.ConsoleCommand;
import com.jailmango.netty.lightman.netty.app.packet.request.LoginRequestPacket;

/**
 * LoginConsoleCommand
 *
 * @author jailmango
 * @CreateDate 2019/9/26
 * @see com.jailmango.netty.lightman.netty.app.client.console.impl
 * @since R9.0
 */
public class LoginConsoleCommand implements ConsoleCommand {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(LoginConsoleCommand.class);

    @Override
    public void execute(Scanner scanner, Channel channel) {
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
        logger.info("请输入用户名:");
        loginRequestPacket.setUserName(scanner.nextLine());
        logger.info("请输入密码:");
        loginRequestPacket.setPassword(scanner.nextLine());

        channel.writeAndFlush(loginRequestPacket);

        waitForResponse();
    }

    /**
     * 等待响应
     */
    private void waitForResponse() {
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
    }
}
