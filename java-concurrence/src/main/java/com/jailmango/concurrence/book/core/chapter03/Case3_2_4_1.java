package com.jailmango.concurrence.book.core.chapter03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case3_2_4_1 - 3.2.4.1 Thread.sleep(long)方法不释放锁
 * 本例中ThreadA和ThreadB，持有相同的锁。通过结果可以表明，Thread.sleep(long)方法不释放锁。
 *
 * @author he.gang33
 * @CreateDate 2019/12/19
 * @see com.jailmango.concurrence.book.core.chapter03
 * @since R9.0
 */
public class Case3_2_4_1 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case3_2_4_1.class);

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
                    Thread.sleep(6000);
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
