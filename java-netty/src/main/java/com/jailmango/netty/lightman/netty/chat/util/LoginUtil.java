package com.jailmango.netty.lightman.netty.chat.util;

import org.apache.commons.lang3.StringUtils;

import io.netty.channel.Channel;
import io.netty.util.Attribute;

import com.jailmango.netty.lightman.netty.chat.attribute.Attributes;

/**
 * LoginUtil
 *
 * @author he.gang33
 * @CreateDate 2019-08-09
 * @see com.jailmango.netty.lightman.netty.chat.util
 * @since R9.0
 */
public class LoginUtil {

    /**
     * true
     */
    private static final String TRUE = "true";

    /**
     * 标记为登录
     * 
     * @param channel Channel
     */
    public static void markAsLogin(Channel channel) {
        channel.attr(Attributes.LOGIN).set(TRUE);
    }

    /**
     * 判断是否处于已登录
     * 
     * @param channel Channel
     * @return boolean
     */
    public static boolean hasLogin(Channel channel) {
        Attribute<String> attr = channel.attr(Attributes.LOGIN);
        return null != attr && StringUtils.isNotBlank(attr.get()) && TRUE.equals(attr.get());
    }
}
