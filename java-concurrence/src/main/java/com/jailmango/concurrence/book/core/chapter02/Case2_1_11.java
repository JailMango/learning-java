package com.jailmango.concurrence.book.core.chapter02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case2_1_11 - 2.1.11 holdsLock(Object obj)方法的使用
 *
 * @author he.gang33
 * @CreateDate 2019-05-24
 * @see com.jailmango.concurrence.book.core.chapter02
 * @since R9.0
 */
public class Case2_1_11 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case2_1_11.class);

    public static void main(String[] args) {
        logger.info("Thread[{}] holds lock. [{}]", Thread.currentThread().getName(),
            Thread.holdsLock(Case2_1_11.class));

        synchronized (Case2_1_11.class) {
            logger.info("Thread[{}] holds lock. [{}]", Thread.currentThread().getName(),
                Thread.holdsLock(Case2_1_11.class));
        }

        logger.info("Thread[{}] holds lock. [{}]", Thread.currentThread().getName(),
            Thread.holdsLock(Case2_1_11.class));
    }
}
