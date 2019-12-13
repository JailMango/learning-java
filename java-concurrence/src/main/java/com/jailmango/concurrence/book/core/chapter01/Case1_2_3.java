package com.jailmango.concurrence.book.core.chapter01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case1_2_3 - 1.2.3 线程执行随机性
 *
 * @author he.gang33
 * @CreateDate 2019-05-16
 * @see com.jailmango.concurrence.book.core.chapter01
 * @since R9.0
 */
public class Case1_2_3 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case1_2_3.class);

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                logger.info(Thread.currentThread().getName() + " running...");
            }
        }).start();

        while (true) {
            logger.info(Thread.currentThread().getName() + " running...");
        }

    }
}
