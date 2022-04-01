package com.jailmango.concurrence.ifeve.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

/**
 * CreateThreadPool
 *
 * @author jailmango
 * @CreateDate 2018/11/14
 * @see com.jailmango.java.concurrence.ifeve.thread.pool
 * @since R9.0<br>
 */
public class CreateThreadPool {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(CreateThreadPool.class);

    /**
     * main
     *
     * @param args String[]
     * @throws InterruptedException InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        // 创建线程池
        createThreadPoolWithThreadPoolExecutor();
    }

    /**
     * 创建线程池 - 最基本的方法, 不建议使用
     *
     * @throws InterruptedException InterruptedException
     */
    private static void createThreadPool() throws InterruptedException {
        logger.info("======================================");
        ExecutorService fixedPool = Executors.newFixedThreadPool(2);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 5; i++) {
            fixedPool.execute(new Job());
        }

        fixedPool.shutdown();

        while (!fixedPool.awaitTermination(1, TimeUnit.SECONDS)) {
            logger.info("Thread pool is doing jobs...");
        }

        long endTime = System.currentTimeMillis();

        logger.info("Total: " + (endTime - startTime));
        logger.info("======================================");
    }

    /**
     * 通过guava创建线程池
     * 
     * @throws InterruptedException InterruptedException
     */
    private static void createThreadPoolWithThreadPoolExecutor() throws InterruptedException {
        logger.info("======================================");
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("thread-pool-%d").build();

        ExecutorService threadPool = new ThreadPoolExecutor(2, 3, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1024),
            threadFactory, new ThreadPoolExecutor.AbortPolicy());

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 5; i++) {
            threadPool.execute(new Job());
        }

        threadPool.shutdown();

        while (!threadPool.awaitTermination(1, TimeUnit.SECONDS)) {
            logger.info("Thread pool is doing jobs...");
        }

        long endTime = System.currentTimeMillis();

        logger.info("Total: " + (endTime - startTime));
        logger.info("======================================");
    }
}
