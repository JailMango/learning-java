package com.jailmango.netty.lightman.netty.chat.attribute;

import java.util.Date;

import io.netty.util.AttributeKey;

/**
 * Attributes
 *
 * @author he.gang33
 * @CreateDate 2019-08-09
 * @see com.jailmango.netty.lightman.netty.chat.attribute
 * @since R9.0
 */
public final class Attributes {

    /**
     * 是否已登录
     */
    public static final AttributeKey<String> LOGIN = AttributeKey.newInstance("IS_LOGIN");

    /**
     * 处理完成时间
     */
    public static final AttributeKey<Date> COMPLETED_DATE = AttributeKey.newInstance("COMPLETED_DATE");

}
