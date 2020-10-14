package com.jailmango.concurrence.book.action.chapter03;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import lombok.extern.slf4j.Slf4j;

import com.google.common.util.concurrent.MoreExecutors;

/**
 * Guava对线程池的扩展_3_2_10
 *
 * @author he.gang33
 * @CreateDate 2020/10/9
 * @see com.jailmango.concurrence.book.action.chapter03
 * @since R9.0
 */
@Slf4j
public class Guava对线程池的扩展_Daemon线程池_3_2_10 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        MoreExecutors.getExitingExecutorService(threadPoolExecutor);
        threadPoolExecutor.execute(() -> log.info("doing..."));
    }
}
