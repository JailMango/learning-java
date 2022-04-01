package com.jailmango.netty.lightman.netty.app.util;

import java.util.UUID;

/**
 * IDUtil
 *
 * @author jailmango
 * @CreateDate 2019/11/22
 * @see com.jailmango.netty.lightman.netty.app.util
 * @since R9.0
 */
public final class IDUtil {

    /**
     * generateID
     * 
     * @return String
     */
    public static String generateID() {
        return UUID.randomUUID().toString().split("-")[0];
    }
}
