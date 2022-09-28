package com.jailmango.netty.demo;

import io.netty.util.HashedWheelTimer;
import io.netty.util.TimerTask;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * TimeWheelDemo
 *
 * @author gang.he2
 * @CreateDate 2022/4/6
 * @see com.jailmango.netty.demo
 */
@Slf4j
public class TimeWheelDemo {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        HashedWheelTimer timer = new HashedWheelTimer();
        timer.start();

        TimerTask task = timeout -> {
            for (int i = 0; i < 100; i++) {
                log.info("do...");
            }
        };

        timer.newTimeout(task, 5000L, TimeUnit.MILLISECONDS);
    }
}
