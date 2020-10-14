package com.jailmango.concurrence.book.action.chapter03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

/**
 * 线程池拒绝策略_3_2_4
 *
 * @author he.gang33
 * @CreateDate 2020/10/9
 * @see com.jailmango.concurrence.book.action.chapter03
 * @since R9.0
 */
@Slf4j
public class 线程池拒绝策略_3_2_4 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = new ThreadPoolExecutor(2, 2, 0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(10), (r, executor) -> log.info("reject {}...", r.toString()));
        MyRunnable myRunnable = new MyRunnable();

        for (int i = 0; i < 100; i++) {
            executorService.submit(myRunnable);
        }
    }

    private static class MyRunnable implements Runnable {

        @Override
        public void run() {
            log.info("doing task...");
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
