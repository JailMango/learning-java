package com.jailmango.netty.demo;

import java.io.Serializable;

/**
 * AskParam
 *
 * @author jailmango
 * @CreateDate 2019-06-12
 * @see com.jailmango.netty.demo
 * @since R9.0
 */
public class AskParam implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -2964983637358367073L;

    private String auth;

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }
}
