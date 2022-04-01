package com.jailmango.netty.lightman.netty.app.client.console;

import java.util.Scanner;

import io.netty.channel.Channel;

/**
 * ConsoleCommand
 *
 * @author jailmango
 * @CreateDate 2019/9/20
 * @see com.jailmango.netty.lightman.netty.app.client.console
 * @since R9.0
 */
public interface ConsoleCommand {

    /**
     * 执行
     * @param scanner Scanner
     * @param channel Channel
     */
    void execute(Scanner scanner, Channel channel);
}
