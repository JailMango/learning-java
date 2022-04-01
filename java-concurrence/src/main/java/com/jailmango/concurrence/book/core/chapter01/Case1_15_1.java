package com.jailmango.concurrence.book.core.chapter01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case1_15_1 - 1.15 守护线程
 *
 * @author jailmango
 * @CreateDate 2019-05-23
 * @see com.jailmango.concurrence.book.core.chapter01
 * @since R9.0
 */
public class Case1_15_1 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case1_15_1.class);

    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread("Daemon Thread");
        // 设置该线程为守护线程，主线程main为用户线程。
        // 由于main线程是用户线程，因此当执行完打印日志，用户线程结束，因此守护线程随之结束

        // 设置守护线程要在start()方法之前
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(5000);

        logger.info("main end...");
    }

    static class MyThread extends Thread {

        /**
         * Constructor
         * 
         * @param name String
         */
        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            int i = 0;

            while (true) {
                try {
                    logger.info("Thread: [{}], Count: [{}]", Thread.currentThread().getName(), ++i);
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {
                    logger.error(e.getLocalizedMessage());
                }
            }
        }
    }

}
