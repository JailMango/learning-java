package com.jailmango.spring.boot.redis.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * SeqUtils
 *
 * @author he.gang33
 * @CreateDate 2019-01-29
 * @see com.jailmango.java.spring.boot.redis.utils
 * @since R9.0
 */
@Component("seqUtils")
public final class SeqUtils {

    /**
     * redisTemplate
     */
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 获取序列之
     * 
     * @param sequenceName String
     * @return Long
     */
    public Long getSequence(String sequenceName) {
        return redisTemplate.opsForValue().increment(sequenceName);
    }
}
