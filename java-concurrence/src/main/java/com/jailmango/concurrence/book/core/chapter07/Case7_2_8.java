package com.jailmango.concurrence.book.core.chapter07;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case7_2_8
 *
 * @author he.gang33
 * @CreateDate 2020/9/7
 * @see com.jailmango.concurrence.book.core.chapter07
 * @since R9.0
 */
public class Case7_2_8 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case7_2_8.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Runnable runnable = () -> {
            while (true) {

            }
        };

        int count = 2;
        Thread[] threads = new Thread[count];

        for (int i = 0; i < 2; i++) {
            threads[i] = new Thread(runnable);
        }
        logger.info("活动的线程数[{}]", Thread.activeCount());

        for (int i = 0; i < 2; i++) {
            threads[i].start();
        }
        logger.info("活动的线程数[{}]", Thread.activeCount());

        Thread[] array = new Thread[Thread.activeCount()];
        Thread.enumerate(array);

        for (int i = 0; i < array.length; i++) {
            if (null != array[i]) {
                logger.info("线程[{}]", array[i].getName());
            }
        }

    }
}
