package com.jailmango.concurrence.book.core.chapter07;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 7.1.4 验证WAITING
 *
 * @author he.gang33
 * @CreateDate 2020/9/7
 * @see com.jailmango.concurrence.book.core.chapter07
 * @since R9.0
 */
public class Case7_1_4 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case7_1_4.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            try {
                synchronized (Lock.LOCK) {
                    Lock.LOCK.wait();
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        Thread.sleep(1000);
        thread2.start();
        Thread.sleep(1000);

        logger.info("State: [{}]", thread1.getState());
        logger.info("State: [{}]", thread2.getState());
    }

    private static class Lock {

        /**
         * LOCK
         */
        public static final Byte LOCK = new Byte("0");
    }
}
