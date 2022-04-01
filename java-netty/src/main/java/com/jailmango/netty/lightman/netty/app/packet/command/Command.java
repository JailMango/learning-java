package com.jailmango.netty.lightman.netty.app.packet.command;

/**
 * Command
 *
 * @author jailmango
 * @CreateDate 2019/9/3
 * @see com.jailmango.netty.lightman.netty.app.packet.command
 * @since R9.0
 */
public interface Command {

    /**
     * 登录请求
     */
    Byte LOGIN_REQUEST = 1;

    /**
     * 登录响应
     */
    Byte LOGIN_RESPONSE = 2;

    /**
     * 发消息请求
     */
    Byte MESSAGE_REQUEST = 3;

    /**
     * 发消息响应
     */
    Byte MESSAGE_RESPONSE = 4;

    /**
     * 注销请求
     */
    Byte LOGOUT_REQUEST = 5;

    /**
     * 注销响应
     */
    Byte LOGOUT_RESPONSE = 6;

    /**
     * 创建群聊请求
     */
    Byte CREATE_GROUP_REQUEST = 7;

    /**
     * 创建群聊响应
     */
    Byte CREATE_GROUP_RESPONSE = 8;

    /**
     * 加入群聊请求
     */
    Byte JOIN_GROUP_REQUEST = 9;

    /**
     * 加入群聊响应
     */
    Byte JOIN_GROUP_RESPONSE = 10;

    /**
     * 退出群聊请求
     */
    Byte QUIT_GROUP_REQUEST = 11;

    /**
     * 退出群聊响应
     */
    Byte QUIT_GROUP_RESPONSE = 12;

    /**
     * 列出群聊成员请求
     */
    Byte LIST_GROUP_MEMBERS_REQUEST = 13;

    /**
     * 列出群聊成员响应
     */
    Byte LIST_GROUP_MEMBERS_RESPONSE = 14;

    /**
     * 群聊消息请求
     */
    Byte GROUP_MESSAGE_REQUEST = 15;

    /**
     * 群聊消息响应
     */
    Byte GROUP_MESSAGE_RESPONSE = 16;

    /**
     * 心跳消息请求
     */
    Byte HEART_BEAT_REQUEST = 17;

    /**
     * 心跳消息响应
     */
    Byte HEART_BEAT_RESPONSE = 18;
}
