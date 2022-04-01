package com.jailmango.concurrence.book.core.chapter03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case3_2_2 - 3.2.2 join()方法和interrupt()方法出现异常
 *
 * @author jailmango
 * @CreateDate 2019-07-25
 * @see com.jailmango.concurrence.book.core.chapter03
 * @since R9.0
 */
public class Case3_2_2 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case3_2_2.class);

    /**
     * main
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        logger.info("主线程main开始...");
        try {
            ThreadB thb = new ThreadB();
            thb.start();

            Thread.sleep(100);

            ThreadC thc = new ThreadC(thb);
            thc.start();
        }
        catch (InterruptedException e) {
            logger.info("主线程main捕获InterruptedException异常...");
            e.printStackTrace();
        }

        logger.info("主线程main结束...");
    }

    private static class ThreadA extends Thread {

        @Override
        public void run() {
            logger.info("线程A开始...");
            for (int i = 0; i < 200; i++) {
                try {
                    Thread.sleep(1);
                }
                catch (InterruptedException e) {
                    logger.info("线程A捕获InterruptedException异常...");
                    e.printStackTrace();
                }
                logger.info("线程A -> {} -> {}", i + 1, Math.random());
            }

            logger.info("线程A结束...");
        }
    }

    private static class ThreadB extends Thread {

        @Override
        public void run() {
            logger.info("线程B开始...");
            try {
                ThreadA tha = new ThreadA();
                tha.start();
                tha.join();
            }
            catch (InterruptedException e) {
                logger.info("线程B捕获了InterruptedException异常...");
                e.printStackTrace();
            }
            logger.info("线程B结束...");
        }
    }

    private static class ThreadC extends Thread {

        /**
         * ThreadB
         */
        private ThreadB thb;

        /**
         * Constructor
         * 
         * @param thb ThreadB
         */
        public ThreadC(ThreadB thb) {
            this.thb = thb;
        }

        @Override
        public void run() {
            thb.interrupt();
        }
    }
}
