package com.jailmango.concurrence.exercise;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 测试有关异常处理的内容
 *
 * @author he.gang33
 * @CreateDate 2021/11/24
 * @see com.jailmango.concurrence.exercise
 */
@Slf4j
public class ThreadPoolException {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        ExecutorService pool = new ThreadPoolExecutor(5, 10, 600L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(20), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 100; i++) {
            try {
                pool.execute(new ExceptionTask(i));
            } catch (Exception e) {
                log.error("Error.", e);
            }
        }
    }

    private static class ExceptionTask implements Runnable {

        private int num;

        public ExceptionTask(int num) {
            this.num = num;
        }

        @Override
        public void run() {
            // if (num % 2 == 0) {
            //     throw new RuntimeException("runtime-exception");
            // }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("success {}", num);
        }
    }
}
