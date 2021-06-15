package com.jailmango.concurrence.book.async.chapter02;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 2.2.1 - 显式使用线程池
 *
 * @author gang.he2
 * @see com.jailmango.concurrence.book.async.chapter02
 */
@Slf4j
public class Case2_2_1 {

    /**
     * main
     *
     * @param args
     *            String[]
     */
    public static void main(String[] args) throws InterruptedException {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = new ThreadPoolExecutor(availableProcessors, availableProcessors * 2, 1, TimeUnit.MINUTES,
            new LinkedBlockingDeque<>(5), new ThreadPoolExecutor.CallerRunsPolicy());

        long start = System.currentTimeMillis();

        executorService.execute(Case2_2_1::doSomethingA);
        executorService.execute(Case2_2_1::doSomethingB);

        long end = System.currentTimeMillis();

        log.info("Cost -> {}ms", end - start);

        Thread.currentThread().join();
    }

    private static void doSomethingA() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("do A...");
    }

    private static void doSomethingB() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("do B...");
    }
}
