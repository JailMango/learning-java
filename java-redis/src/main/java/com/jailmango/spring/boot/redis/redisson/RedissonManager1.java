package com.jailmango.spring.boot.redis.redisson;

import java.util.concurrent.TimeUnit;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import lombok.extern.slf4j.Slf4j;

/**
 * RedissonManager
 *
 * @author jailmango
 * @CreateDate 2021/2/24
 * @see com.jailmango.spring.boot.redis.redisson
 * @since R9.0
 */
@Slf4j
public class RedissonManager1 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://172.16.24.56:6379");
        RedissonClient redissonClient = Redisson.create(config);

        final RLock lock = redissonClient.getLock("redis-lock");
        try {
            lock.lockInterruptibly(10L, TimeUnit.MINUTES);

            log.info("doing work...");
            Thread.sleep(10000000L);
            log.info("doing1 work...");
            lock.unlock();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
            log.info("catch InterruptedException...");
        }

    }

}
