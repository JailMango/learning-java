package com.jailmango.concurrence.book.action.chapter03;

import java.util.concurrent.Executor;

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
public class Guava对线程池的扩展_特殊的DirectExecutor线程池_3_2_10 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        Executor executor = MoreExecutors.directExecutor();
        executor.execute(() -> {
            for (int i = 0; i < 100; i++) {
                log.info("{} -> i = {}", Thread.currentThread().getName(), i);
                try {
                    Thread.sleep(50);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread.sleep(1000);
        log.info("end...");
    }
}
