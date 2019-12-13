package com.jailmango.spring.boot.redis.configuration;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * RedisProjConfiguration
 *
 * @author he.gang33
 * @CreateDate 2019-01-25
 * @see com.jailmango.java.spring.boot.redis.configuration
 * @since R9.0
 */
@Configuration
@ComponentScan(basePackages = {
        "com.jailmango.java.spring.boot.redis.utils", "com.jailmango.java.spring.boot.redis.controller",
        "com.jailmango.java.spring.boot.redis.service.impl"
})
@EnableCaching
public class RedisProjConfiguration {

}
