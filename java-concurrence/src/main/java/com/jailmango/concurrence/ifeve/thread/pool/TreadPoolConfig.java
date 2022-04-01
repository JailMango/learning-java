package com.jailmango.concurrence.ifeve.thread.pool;

import java.util.concurrent.ExecutorService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TreadPoolConfig
 *
 * @author jailmango
 * @CreateDate 2018/11/14
 * @see com.jailmango.java.concurrence.ifeve.thread.pool
 * @since R9.0<br>
 */
@Configuration
public class TreadPoolConfig {

    /**
     * 线程池
     * 
     * @return ExecutorService
     */
    @Bean(value = "consumerQueueThreadPool")
    public ExecutorService buildConsumerQueueThreadPool() {
        return null;
    }
}
