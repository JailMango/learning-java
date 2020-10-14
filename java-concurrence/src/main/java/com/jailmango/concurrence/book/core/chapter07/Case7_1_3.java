package com.jailmango.concurrence.book.core.chapter07;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 7.1.3 验证BLOCKED状态
 *
 * @author he.gang33
 * @CreateDate 2020/9/7
 * @see com.jailmango.concurrence.book.core.chapter07
 * @since R9.0
 */
public class Case7_1_3 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case7_1_3.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            Service.doService();
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        Thread.sleep(1000);
        thread2.start();
        logger.info("State: [{}]", thread1.getState());
        logger.info("State: [{}]", thread2.getState());
    }

    private static class Service {

        public static synchronized void doService() {
            try {
                logger.info("doing service...");
                Thread.sleep(10000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
