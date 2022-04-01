package com.jailmango.concurrence.book.action.chapter03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import lombok.extern.slf4j.Slf4j;

/**
 * 信号量_允许多个线程同时访问_3_1_3
 *
 * @author jailmango
 * @CreateDate 2020/10/6
 * @see com.jailmango.concurrence.book.action.chapter03
 * @since R9.0
 */
@Slf4j
public class C3_1_3_信号量Semaphore_允许多个线程同时访问 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        MyRunnable myRunnable = new MyRunnable();

        for (int i = 0; i < 10; i++) {
            executorService.submit(myRunnable);
        }
    }

    private static class MyRunnable implements Runnable {

        private final Semaphore semaphore = new Semaphore(5);

        @Override
        public void run() {
            try {
                semaphore.acquire();
                log.info("get semaphore...");
                Thread.sleep(5000);
                log.info("end...");
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                semaphore.release();
                log.info("release semaphore...");
            }
        }
    }
}
