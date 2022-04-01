package com.jailmango.netty.lightman.netty.app.attribute;

import io.netty.util.AttributeKey;

import com.jailmango.netty.lightman.netty.app.session.Session;

/**
 * Attributes
 *
 * @author jailmango
 * @CreateDate 2019/9/5
 * @see com.jailmango.netty.lightman.netty.app.attribute
 * @since R9.0
 */
public interface Attributes {

    /**
     * SESSION
     */
    AttributeKey<Session> SESSION = AttributeKey.newInstance("session");
}
