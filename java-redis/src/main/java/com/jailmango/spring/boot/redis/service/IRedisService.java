package com.jailmango.spring.boot.redis.service;

import com.jailmango.spring.boot.redis.model.RedisValue;
import com.jailmango.spring.boot.redis.model.RedisUserDto;

/**
 * IRedisService
 *
 * @author he.gang33
 * @CreateDate 2019-01-25
 * @see com.jailmango.java.spring.boot.redis.service
 * @since R9.0
 */
public interface IRedisService {

    /**
     * setValue
     * 
     * @param value RedisValue
     * @return RedisValue
     */
    RedisValue setValue(RedisValue value);

    /**
     * getValue
     * 
     * @param key String
     * @return RedisValue
     */
    RedisValue getValue(String key);

    /**
     * deleteValue
     * 
     * @param key String
     * @return boolean
     */
    boolean deleteValue(String key);

    /**
     * addUser
     * 
     * @param user RedisUserDto
     * @return RedisUserDto
     */
    RedisUserDto addUser(RedisUserDto user);

    /**
     * queryUser
     * 
     * @param userId Long
     * @return RedisUserDto
     */
    RedisUserDto queryUser(Long userId);

    /**
     * addUser
     * 
     * @param user RedisUserDto
     * @return RedisUserDto
     */
    RedisUserDto addUserHash(RedisUserDto user);

    /**
     * modUserHash
     *
     * @param userId Long
     * @param user RedisUserDto
     * @return RedisUserDto
     */
    RedisUserDto modUserHash(Long userId, RedisUserDto user);

    /**
     * queryUserHash
     * 
     * @param userId Long
     * @return RedisUserDto
     */
    RedisUserDto queryUserHash(Long userId);

    /**
     * deleteUserHash
     * 
     * @param userId Long
     * @return boolean
     */
    boolean deleteUserHash(Long userId);
}
