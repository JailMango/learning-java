package com.jailmango.concurrence.book.action.chapter03;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lombok.extern.slf4j.Slf4j;

/**
 * 倒计数器CountDownLatch_3_1_5
 *
 * @author he.gang33
 * @CreateDate 2020/10/7
 * @see com.jailmango.concurrence.book.action.chapter03
 * @since R9.0
 */
@Slf4j
public class 倒计数器CountDownLatch_3_1_5 {

    private static final CountDownLatch end = new CountDownLatch(10);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        MyRunnable runnable = new MyRunnable();
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 20; i++) {
            executorService.submit(runnable);
        }

        end.await();

        log.info("Fire...");

        executorService.shutdown();
    }

    private static class MyRunnable implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                log.info("check complete {}...");
                end.countDown();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
