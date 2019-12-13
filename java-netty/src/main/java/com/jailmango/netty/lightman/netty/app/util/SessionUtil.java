package com.jailmango.netty.lightman.netty.app.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;

import com.jailmango.netty.lightman.netty.app.attribute.Attributes;
import com.jailmango.netty.lightman.netty.app.session.Session;

/**
 * SessionUtil
 *
 * @author he.gang33
 * @CreateDate 2019/9/5
 * @see com.jailmango.netty.lightman.netty.app.util
 * @since R9.0
 */
public class SessionUtil {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(SessionUtil.class);

    /**
     * userChannelMap
     */
    private static final Map<String, Channel> userIdChannelMap = new ConcurrentHashMap<>();

    /**
     * userNameChannelMap
     */
    private static final Map<String, String> userNameMap = new ConcurrentHashMap<>();

    /**
     * groupIdChannelGroupMap
     */
    private static final Map<String, ChannelGroup> groupIdChannelGroupMap = new ConcurrentHashMap<>();

    /**
     * groupNameMap
     */
    private static final Map<String, String> groupNameMap = new ConcurrentHashMap<>();

    /**
     * 绑定Session
     *
     * @param session Session
     * @param channel Channel
     */
    public static void bindSession(Session session, Channel channel) {
        if (null != userIdChannelMap.get(session.getUserId())) {
            logger.info("已经绑定过Session...");
        }

        userIdChannelMap.put(session.getUserId(), channel);
        channel.attr(Attributes.SESSION).set(session);

        userNameMap.put(session.getUserName(), session.getUserId());
    }

    /**
     * 解绑Session
     *
     * @param channel Channel
     */
    public static void unbindSession(Channel channel) {
        if (hasLogin(channel)) {
            userNameMap.remove(getSession(channel).getUserName());
            userIdChannelMap.remove(getSession(channel).getUserId());
            channel.attr(Attributes.SESSION).set(null);
        }
    }

    /**
     * 是否已登录
     *
     * @param channel Channel
     * @return boolean
     */
    public static boolean hasLogin(Channel channel) {
        return null != getSession(channel);
    }

    /**
     * 获取Session
     *
     * @param channel Channel
     * @return Session
     */
    public static Session getSession(Channel channel) {
        return channel.attr(Attributes.SESSION).get();
    }

    /**
     * 获取Channel
     *
     * @param userId String
     * @return Channel
     */
    public static Channel getChannel(String userId) {
        return userIdChannelMap.get(userId);
    }

    /**
     * 获取用户标识
     *
     * @param userName String
     * @return String
     */
    public static String getUserId(String userName) {
        return userNameMap.get(userName);
    }

    /**
     * 绑定ChannelGroup
     *
     * @param groupName String
     * @param groupId String
     * @param channelGroup ChannelGroup
     */
    public static void bindChannelGroup(String groupName, String groupId, ChannelGroup channelGroup) {
        groupNameMap.put(groupName, groupId);
        groupIdChannelGroupMap.put(groupId, channelGroup);
    }

    /**
     * 解绑ChannelGroup
     * 
     * @param groupName String
     * @param groupId String
     */
    public static void unbindChannelGroup(String groupName, String groupId) {
        groupNameMap.remove(groupName);
        groupIdChannelGroupMap.remove(groupId);
    }

    /**
     * 获取ChannelGroup
     *
     * @param groupId String
     * @return ChannelGroup
     */
    public static ChannelGroup getChannelGroup(String groupId) {
        return groupIdChannelGroupMap.get(groupId);
    }

    /**
     * 获取群聊标识
     *
     * @param groupName String
     * @return String
     */
    public static String getGroupId(String groupName) {
        return groupNameMap.get(groupName);
    }
}
