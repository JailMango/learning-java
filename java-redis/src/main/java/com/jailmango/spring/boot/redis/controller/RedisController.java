package com.jailmango.spring.boot.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jailmango.spring.boot.redis.model.RedisUserDto;
import com.jailmango.spring.boot.redis.model.RedisValue;
import com.jailmango.spring.boot.redis.service.IRedisService;

/**
 * RedisController
 *
 * @author jailmango
 * @CreateDate 2019-01-25
 * @see com.jailmango.java.spring.boot.redis.controller
 * @since R9.0
 */
@RestController
@RequestMapping("redis")
public class RedisController {

    /**
     * service
     */
    @Autowired
    private IRedisService service;

    /**
     * setValue
     * 
     * @param value RedisValue
     * @return RedisValue
     */
    @RequestMapping(value = "setValue", method = RequestMethod.POST)
    public RedisValue setValue(@RequestBody RedisValue value) {
        return service.setValue(value);
    }

    /**
     * getValue
     * 
     * @param key getValue
     * @return RedisValue
     */
    @RequestMapping(value = "getValue", method = RequestMethod.GET)
    public RedisValue getValue(String key) {
        return service.getValue(key);
    }

    /**
     * deleteValue
     * 
     * @param key String
     * @return boolean
     */
    @RequestMapping(value = "deleteValue/{key}", method = RequestMethod.DELETE)
    public boolean deleteValue(@PathVariable String key) {
        return service.deleteValue(key);
    }

    /**
     * addUser
     * 
     * @param user RedisUserDto
     * @return RedisUserDto
     */
    @RequestMapping(value = "user", method = RequestMethod.POST)
    public RedisUserDto addUser(@RequestBody RedisUserDto user) {
        return service.addUser(user);
    }

    /**
     * queryUser
     * 
     * @param userId Long
     * @return RedisUserDto
     */
    @RequestMapping(value = "user/{userId}", method = RequestMethod.GET)
    public RedisUserDto queryUser(@PathVariable Long userId) {
        return service.queryUser(userId);
    }

    /**
     * addUserHash
     *
     * @param user RedisUserDto
     * @return RedisUserDto
     */
    @RequestMapping(value = "userhash", method = RequestMethod.POST)
    public RedisUserDto addUserHash(@RequestBody RedisUserDto user) {
        return service.addUserHash(user);
    }

    /**
     * queryUserHash
     *
     * @param userId Long
     * @return RedisUserDto
     */
    @RequestMapping(value = "userhash/{userId}", method = RequestMethod.GET)
    public RedisUserDto queryUserHash(@PathVariable Long userId) {
        return service.queryUserHash(userId);
    }

    /**
     * deleteUserHash
     * 
     * @param userId Long
     * @return boolean
     */
    @RequestMapping(value = "userhash/{userId}", method = RequestMethod.DELETE)
    public boolean deleteUserHash(@PathVariable Long userId) {
        return service.deleteUserHash(userId);
    }

    /**
     * modUserHash
     * 
     * @param userId Long
     * @param user RedisUserDto
     * @return RedisUserDto
     */
    @RequestMapping(value = "userhash/{userId}", method = RequestMethod.PUT)
    public RedisUserDto modUserHash(@PathVariable Long userId, @RequestBody RedisUserDto user) {
        return service.modUserHash(userId, user);
    }
}
