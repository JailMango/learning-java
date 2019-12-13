package com.jailmango.spring.boot.redis.model;

import java.io.Serializable;

/**
 * RedisUserDto
 *
 * @author he.gang33
 * @CreateDate 2019-01-28
 * @see com.jailmango.java.spring.boot.redis.model
 * @since R9.0
 */
public class RedisUserDto implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -1840152167102220741L;

    /**
     * userId
     */
    private Long userId;

    /**
     * userName
     */
    private String userName;

    /**
     * password
     */
    private String password;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
