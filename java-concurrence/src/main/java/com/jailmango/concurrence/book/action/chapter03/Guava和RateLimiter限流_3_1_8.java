package com.jailmango.concurrence.book.action.chapter03;

import lombok.extern.slf4j.Slf4j;

import com.google.common.util.concurrent.RateLimiter;

/**
 * Guava和RateLimiter限流_3_1_8
 *
 * @author he.gang33
 * @CreateDate 2020/10/8
 * @see com.jailmango.concurrence.book.action.chapter03
 * @since R9.0
 */
@Slf4j
public class Guava和RateLimiter限流_3_1_8 {

    private static RateLimiter rateLimiter = RateLimiter.create(2);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            // 该方法不会阻塞，直接返回true/flase
            // if (!rateLimiter.tryAcquire()) {
            //    continue;
            //}
            // 阻塞等待令牌
            rateLimiter.acquire();
            new Thread(new Task()).start();
        }
    }

    private static class Task implements Runnable {

        @Override
        public void run() {
            log.info("doing task...");
        }
    }
}
