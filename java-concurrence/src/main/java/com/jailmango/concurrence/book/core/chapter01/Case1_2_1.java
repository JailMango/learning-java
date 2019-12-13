package com.jailmango.concurrence.book.core.chapter01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case1_2_1 - 1.2.1 创建线程
 *
 * @author he.gang33
 * @CreateDate 2019-05-08
 * @see com.jailmango.concurrence.book.core.chapter01
 * @since R9.0
 */
public class Case1_2_1 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case1_2_1.class);

    /**
     * main
     * 
     * @param args String[]
     * @throws InterruptedException InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        logger.info("Main running...");
        logger.info(Thread.currentThread().getName());
        Thread myThread = new Thread(new MyThread());
        myThread.start();
        Thread.sleep(1000);
        logger.info("Main done...");
    }

    /**
     * MyThread
     */
    static class MyThread implements Runnable {

        @Override
        public void run() {
            logger.info("MyThread running...");
            logger.info(Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
                logger.info("MyThread done.");
            }
            catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }
        }
    }
}
