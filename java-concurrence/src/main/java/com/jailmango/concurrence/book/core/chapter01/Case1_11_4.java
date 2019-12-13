package com.jailmango.concurrence.book.core.chapter01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case1_11_4
 *
 * @author he.gang33
 * @CreateDate 2019-05-21
 * @see com.jailmango.concurrence.book.core.chapter01
 * @since R9.0
 */
public class Case1_11_4 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case1_11_4.class);

    public static void main(String[] args) throws InterruptedException {
        run1();
    }

    /**
     * 不论是先interrupt()还是先sleep()，只要两者同时出现，就会出现异常
     */
    public static void run1() {
        try {
            MyThread myThread = new MyThread();
            myThread.start();
            Thread.sleep(1000);
            myThread.interrupt();
        }
        catch (InterruptedException e) {
            logger.error("Main catch exception...");
            e.printStackTrace();
        }
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            try {
                logger.info("MyThread running...");
                Thread.sleep(20000);
                logger.info("MyThread end...");
            }
            catch (InterruptedException e) {
                logger.error("MyThread catch exception...");
                e.printStackTrace();
            }

        }
    }
}
