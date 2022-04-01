package com.jailmango.concurrence.book.core.chapter01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case1_5 - 1.5 sleep()
 *
 * @author jailmango
 * @CreateDate 2019-05-21
 * @see com.jailmango.concurrence.book.core.chapter01
 * @since R9.0
 */
public class Case1_5 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case1_5.class);

    /**
     * start
     */
    public static void start() {
        MyThread myThread = new MyThread();
        long beginTime = System.currentTimeMillis();
        logger.info("Start: [{}]", beginTime);

        /**
         * start()启动线程，是正确的启动线程的方法。main线程与MyThread线程是异步执行的。因此，此处消耗的时间很少，因为main线程很快结束。
         * 与run()方法不同的是，run()并非是正确的启动线程的方法，仅仅是调用了该方法，是main线程同步调用，因此cost比start()大很多。
         */
        myThread.start();

        long endTime = System.currentTimeMillis();
        logger.info("End: [{}]", endTime);
        logger.info("Cost: [{}]", endTime - beginTime);
    }

    /**
     * run
     */
    public static void run() {
        MyThread myThread = new MyThread();
        long beginTime = System.currentTimeMillis();
        logger.info("Start: [{}]", beginTime);

        myThread.run();

        long endTime = System.currentTimeMillis();
        logger.info("End: [{}]", endTime);
        logger.info("Cost: [{}]", endTime - beginTime);
    }

    static class MyThread extends Thread {

        @Override
        public void run() {
            logger.info("MyThread running begin...");

            try {
                Thread.sleep(2000);
                sleep(2000);
            }
            catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }

            logger.info("MyThread running end...");
        }
    }
}
