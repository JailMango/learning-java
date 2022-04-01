package com.jailmango.concurrence.book.action.chapter03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

/**
 * 线程池_3_2_1
 *
 * @author jailmango
 * @CreateDate 2020/10/8
 * @see com.jailmango.concurrence.book.action.chapter03
 * @since R9.0
 */
@Slf4j
public class C3_2_2_线程池 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        log.info("开始...");
        scheduledExecutorService.scheduleWithFixedDelay(new MyRunnable(), 1, 1,TimeUnit.SECONDS);
    }

    private static void scheduleAtFixedRate() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        log.info("开始...");
        scheduledExecutorService.scheduleAtFixedRate(new MyRunnable(), 1, 1,TimeUnit.SECONDS);
    }

    private static void cachedThreadPool() throws InterruptedException {
        // Cached线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        MyRunnable myRunnable = new MyRunnable();
        for (int i = 0; i < 10; i++) {
            Thread.sleep(500);
            executorService.submit(myRunnable);
        }
        executorService.shutdown();
    }

    private static void fixedThreadPool() {
        // 固定大小的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        MyRunnable myRunnable = new MyRunnable();
        for (int i = 0; i < 10; i++) {
            executorService.submit(myRunnable);
        }
        executorService.shutdown();
    }

    private static class MyRunnable implements Runnable {

        @Override
        public void run() {
            log.info("doing task...");
            try {
                Thread.sleep(2000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("end doing task...");
        }
    }
}
