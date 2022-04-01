package com.jailmango.spring.boot.redis.utils;

import java.io.Serializable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.jailmango.spring.boot.redis.model.RedisValue;

/**
 * RedisUtils
 *
 * @author jailmango
 * @CreateDate 2019-01-28
 * @see com.jailmango.java.spring.boot.redis.utils
 * @since R9.0
 */
@Component("redisUtils")
public final class RedisUtils {

    /**
     * redisTemplate
     */
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * redisJsonTemplate
     */
    @Autowired
    @Qualifier("redisJsonTemplate")
    private RedisTemplate<String, Serializable> redisJsonTemplate;

    /**
     * convertUtils
     */
    @Autowired
    @Qualifier("convertUtils")
    private ConvertUtils convertUtils;

    /**
     * setValue
     * 
     * @param value RedisValue
     */
    public void setStringValue(RedisValue value) {
        redisTemplate.opsForValue().set(value.getKey(), value.getValue());
    }

    /**
     * getStringValue
     * 
     * @param key String
     * @return String
     */
    public String getStringValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * delete
     * 
     * @param key String
     * @return boolean
     */
    public boolean delete(String key) {
        return redisTemplate.delete(key);
    }

    /**
     * setObjectJsonValue - 以json字符串的格式存储对象
     * 
     * @param key String
     * @param value Serializable
     */
    public void setObjectJsonValue(String key, Serializable value) {
        redisJsonTemplate.opsForValue().set(key, value);
    }

    /**
     * getObjectJsonValue
     * 
     * @param key String
     * @return Serializable
     */
    public Serializable getObjectJsonValue(String key) {
        return redisJsonTemplate.opsForValue().get(key);
    }

    /**
     * setObjectHashValue - 以hash结果存储对象
     * 
     * @param key String
     * @param value Object
     */
    public void setObjectHashValue(String key, Object value) {
        redisJsonTemplate.opsForHash().putAll(key, convertUtils.toMap(value));
    }

    /**
     * getObjectHashValue
     * 
     * @param key String
     * @return Map<Object, Object>
     */
    public Map<Object, Object> getObjectHashValue(String key) {
        return redisJsonTemplate.opsForHash().entries(key);
    }
}
