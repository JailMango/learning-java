package com.jailmango.spring.boot.redis.model;

import java.io.Serializable;

/**
 * RedisValue
 *
 * @author jailmango
 * @CreateDate 2019-01-25
 * @see com.jailmango.java.spring.boot.redis.model
 * @since R9.0
 */
public class RedisValue implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1169969585352668571L;

    /**
     * key
     */
    private String key;

    /**
     * value
     */
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
