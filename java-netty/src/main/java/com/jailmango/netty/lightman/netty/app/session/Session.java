package com.jailmango.netty.lightman.netty.app.session;

import lombok.Data;

/**
 * Session
 *
 * @author he.gang33
 * @CreateDate 2019/9/5
 * @see com.jailmango.netty.lightman.netty.app.session
 * @since R9.0
 */
@Data
public class Session {

    /**
     * userId
     */
    private String userId;

    /**
     * userName
     */
    private String userName;

    /**
     * Constructor
     * 
     * @param userId String
     * @param userName String
     */
    public Session(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Session[id - " + userId + ", name - " + userName + "]";
    }
}
