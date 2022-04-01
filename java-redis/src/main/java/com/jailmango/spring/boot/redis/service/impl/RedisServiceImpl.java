package com.jailmango.spring.boot.redis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.jailmango.spring.boot.redis.annotation.ServiceLog;
import com.jailmango.spring.boot.redis.domain.RedisConst;
import com.jailmango.spring.boot.redis.model.RedisUserDto;
import com.jailmango.spring.boot.redis.model.RedisValue;
import com.jailmango.spring.boot.redis.service.IRedisService;
import com.jailmango.spring.boot.redis.utils.RedisUtils;
import com.jailmango.spring.boot.redis.utils.SeqUtils;
import com.jailmango.spring.boot.redis.utils.ConvertUtils;

/**
 * RedisServiceImpl
 *
 * @author jailmango
 * @CreateDate 2019-01-25
 * @see com.jailmango.java.spring.boot.redis.service.impl
 * @since R9.0
 */
@Service("redisService")
public class RedisServiceImpl implements IRedisService {

    /**
     * RedisUtils
     */
    @Autowired
    private RedisUtils redisUtils;

    /**
     * SeqUtils
     */
    @Autowired
    private SeqUtils seqUtils;

    /**
     * convertUtils
     */
    @Autowired
    private ConvertUtils convertUtils;

    @Override
    @ServiceLog
    public RedisValue setValue(RedisValue value) {
        redisUtils.setStringValue(value);
        return value;
    }

    @Override
    @ServiceLog
    @Cacheable(cacheNames = "spring-cache-string", sync = true,
        unless = "#result == null || #result.value == null || #result.value.equals(\"\")")
    public RedisValue getValue(String key) {
        String value = redisUtils.getStringValue(key);
        RedisValue obj = new RedisValue();
        obj.setKey(key);
        obj.setValue(value);

        return obj;
    }

    @Override
    @CacheEvict(cacheNames = "spring-cache-string")
    public boolean deleteValue(String key) {
        return redisUtils.delete(key);
    }

    @Override
    @ServiceLog
    public RedisUserDto addUser(RedisUserDto user) {
        user.setUserId(seqUtils.getSequence(RedisConst.Sequence.USER_ID_SEQ));
        redisUtils.setObjectJsonValue(getUserKey(user.getUserId()), user);

        return user;
    }

    @Override
    @ServiceLog
    public RedisUserDto queryUser(Long userId) {
        RedisUserDto user = (RedisUserDto) redisUtils.getObjectJsonValue(getUserKey(userId));

        return user;
    }

    @Override
    @ServiceLog
    public RedisUserDto addUserHash(RedisUserDto user) {
        user.setUserId(seqUtils.getSequence(RedisConst.Sequence.USER_ID_SEQ));
        redisUtils.setObjectHashValue(getUserKey(user.getUserId()), user);

        return user;
    }

    @Override
    @ServiceLog
    @CachePut(value = "user-cache", key = "#userId")
    public RedisUserDto modUserHash(Long userId, RedisUserDto user) {
        user.setUserId(userId);

        redisUtils.setObjectHashValue(getUserKey(userId), user);

        return user;
    }

    @Override
    @ServiceLog
    @Cacheable(value = "user-cache", key = "'user-' + #userId",
        unless = "#result == null or #result.userName == null or #result.userName.equals(\"\")")
    public RedisUserDto queryUserHash(Long userId) {
        RedisUserDto user = convertUtils.toObject(redisUtils.getObjectHashValue(getUserKey(userId)),
            RedisUserDto.class);

        return user;
    }

    @Override
    @ServiceLog
    @CacheEvict(value = "user-cache", key = "#userId")
    public boolean deleteUserHash(Long userId) {
        return redisUtils.delete(getUserKey(userId));
    }

    /**
     * getUserKey
     *
     * @param userId Long
     * @return String
     */
    private String getUserKey(Long userId) {
        return RedisConst.Key.USER_KEY + userId;
    }
}
