package com.jailmango.concurrence.book.action.chapter03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

/**
 * 扩展线程池_3_2_6
 *
 * @author he.gang33
 * @CreateDate 2020/10/9
 * @see com.jailmango.concurrence.book.action.chapter03
 * @since R9.0
 */
@Slf4j
public class 扩展线程池_3_2_6 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        log.info("available processors -> {}", Runtime.getRuntime().availableProcessors());
        ExecutorService executorService = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>()) {
            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                log.info("after {}...", r.toString());
            }

            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                log.info("before {}...", r.toString());
            }

            @Override
            protected void terminated() {
                log.info("exit...");
            }
        };

        for (int i = 0; i < 5; i++) {
            executorService.submit(new MyTask("MyTask-" + i));
            Thread.sleep(10);
        }

        executorService.shutdown();
    }

    private static class MyTask implements Runnable {

        private String name;

        public MyTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            log.info("doing task...");
        }
    }
}
