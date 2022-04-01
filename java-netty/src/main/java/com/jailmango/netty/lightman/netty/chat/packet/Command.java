package com.jailmango.netty.lightman.netty.chat.packet;

/**
 * Command
 *
 * @author jailmango
 * @CreateDate 2019-08-05
 * @see com.jailmango.netty.lightman.netty
 * @since R9.0
 */
public class Command {

    /**
     * 登录请求
     */
    public static final Byte LOGIN_REQUEST = 1;

    /**
     * 登录回复
     */
    public static final Byte LOGIN_RESPONSE = 2;

    /**
     * 发送消息请求
     */
    public static final Byte MESSAGE_REQUEST = 3;

    /**
     * 发送消息响应
     */
    public static final Byte MESSAGE_RESPONSE = 4;
}
