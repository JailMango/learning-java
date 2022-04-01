package com.jailmango.concurrence.book.core.chapter03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case3_2_4_2 - 3.2.4.2 join(long)释放锁
 * 由于ThreadA使用了join()释放了锁，因此ThreadB可以调用同步方法。
 * @author jailmango
 * @CreateDate 2019/12/19
 * @see com.jailmango.concurrence.book.core.chapter03
 * @since R9.0
 */
public class Case3_2_4_2 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case3_2_4_2.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        try {
            logger.info("mainThread step1...");

            MyThread myThread = new MyThread();

            ThreadA tha = new ThreadA(myThread);
            tha.start();

            Thread.sleep(50);
            logger.info("mainThread step2...");

            ThreadB thb = new ThreadB(myThread);
            thb.start();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class ThreadA extends Thread {

        /**
         * myThread
         */
        private final MyThread myThread;

        /**
         * Constructor
         *
         * @param myThread MyThread
         */
        public ThreadA(MyThread myThread) {
            super();
            this.myThread = myThread;
        }

        @Override
        public void run() {
            try {
                synchronized (myThread) {
                    logger.info("ThreadA begin...");
                    myThread.start();
                    myThread.join();
                    for (int i = 0; i < 100; i++) {
                        Thread.sleep(10);
                        logger.info("{} -> {}", i, Math.random());
                    }
                    logger.info("ThreadA end...");
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class ThreadB extends Thread {

        /**
         * myThread
         */
        private final MyThread myThread;

        /**
         * Constructor
         *
         * @param myThread MyThread
         */
        public ThreadB(MyThread myThread) {
            super();
            this.myThread = myThread;
        }

        @Override
        public void run() {
            myThread.doService();
        }
    }

    private static class MyThread extends Thread {

        @Override
        public void run() {
            try {
                logger.info("MyThread begin... -> {}", System.currentTimeMillis());
                Thread.sleep(5000);
                logger.info("MyThread end... -> {}", System.currentTimeMillis());
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public synchronized void doService() {
            logger.info("MyThread doService... -> {}", System.currentTimeMillis());
        }
    }
}
