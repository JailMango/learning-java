package com.jailmango.guava.demo;

import com.google.common.util.concurrent.RateLimiter;

/**
 * 限流器
 *
 * @author jailmango
 * @CreateDate 2021/10/9
 * @see com.jailmango.guava.demo
 */
public class 限流器 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        RateLimiter rateLimiter = RateLimiter.create(2);
    }
}
