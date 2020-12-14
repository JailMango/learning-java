package com.jailmango.spring.configuration.redis;

import java.io.Serializable;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * RedisConfiguration
 *
 * @author he.gang33
 * @CreateDate 2020/12/7
 * @see com.jailmango.spring.data.redis
 * @since R9.0
 */
@Configuration
@AutoConfigureAfter(RedisAutoConfiguration.class)
public class RedisConfiguration {

    /**
     * Redis Template
     * 
     * @param redisConnectionFactory LettuceConnectionFactory
     * @return RedisTemplate<String, Serializable>
     */
    @Bean
    public RedisTemplate<String, Serializable> redisCacheTemplate(LettuceConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Serializable> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }
}
