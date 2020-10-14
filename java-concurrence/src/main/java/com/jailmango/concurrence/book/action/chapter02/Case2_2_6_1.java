package com.jailmango.concurrence.book.action.chapter02;

import lombok.extern.slf4j.Slf4j;

/**
 * 2.2.6 等待线程结束(join)和谦让(yield)
 *
 * @author he.gang33
 * @CreateDate 2020/9/18
 * @see com.jailmango.concurrence.book.action.chapter02
 * @since R9.0
 */
@Slf4j
public class Case2_2_6_1 {

    public volatile static int i = 0;

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            for (i = 0; i < 10000; i++) {

            }
        };

        Thread thread = new Thread(runnable, "MyThread-1");
        thread.start();
        // 等待thread执行完毕，主线程继续往下执行
        thread.join();

        log.info("i = {}", i);
    }
}
