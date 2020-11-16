package com.jailmango.concurrence.book.action.chapter03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

/**
 * 自定义线程池_3_2_5
 *
 * @author he.gang33
 * @CreateDate 2020/10/9
 * @see com.jailmango.concurrence.book.action.chapter03
 * @since R9.0
 */
@Slf4j
public class C3_2_5_自定义线程池 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS,
            new SynchronousQueue<>(), r -> {
                Thread t = new Thread(r);
                t.setDaemon(true);
                log.info("create thread {}...", t.getName());
                return t;
            }, (r, executor) -> log.info("reject {}...", r.toString()));

        MyTask task = new MyTask();

        for (int i = 0; i < 2; i++) {
            executorService.submit(task);
        }

        Thread.sleep(2000);
    }

    private static class MyTask implements Runnable {

        @Override
        public void run() {
            while (true) {
                log.info("doing daemon task...");
            }
        }
    }
}
