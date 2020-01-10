package com.jailmango.concurrence.book.core.chapter03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case3_2_7
 *
 * @author he.gang33
 * @CreateDate 2019/12/19
 * @see com.jailmango.concurrence.book.core.chapter03
 * @since R9.0
 */
public class Case3_2_7 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case3_2_7.class);

    /**
     * main
     * 
     * @param args String[]
     * @throws InterruptedException InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        long beginTime = System.currentTimeMillis();
        Thread.currentThread().join(2000, 999999);
        long endTime = System.currentTimeMillis();

        logger.info("{}", endTime - beginTime);
    }
}
