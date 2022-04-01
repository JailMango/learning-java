package com.jailmango.concurrence.book.core.chapter01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case1_11_1 - 1.11.1 停止不了的线程
 *
 * @author jailmango
 * @CreateDate 2019-05-21
 * @see com.jailmango.concurrence.book.core.chapter01
 * @since R9.0
 */
public class Case1_11_1 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case1_11_1.class);

    public static void main(String[] args) throws InterruptedException {
        MyThread th = new MyThread();
        th.start();
        Thread.sleep(10);
        th.interrupt();

        logger.info("main end...");
    }

    static class MyThread extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 200; i++) {
                logger.info(String.valueOf(i + 1));
            }
        }
    }
}
