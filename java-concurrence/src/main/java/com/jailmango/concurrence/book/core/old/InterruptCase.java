package com.jailmango.concurrence.book.core.old;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * InterruptCase
 *
 * @author jailmango
 * @CreateDate 2018-11-23
 * @see com.jailmango.java.book.core.chapter01
 * @since R9.0<br>
 */
public class InterruptCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(InterruptCase.class);

    /**
     * main
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        try {
            Thread thread = new Thread(new InterruptRunnable());
            thread.start();
            logger.info(Thread.currentThread().getName() + "是否停止? - 0 " + Thread.interrupted());
            Thread.sleep(5000);
            thread.interrupt();
            logger.info(Thread.currentThread().getName() + "是否停止? - 1 " + Thread.interrupted());
            logger.info(Thread.currentThread().getName() + "是否停止? - 2 " + Thread.interrupted());
        }
        catch (InterruptedException e) {
            logger.error("Main catch exceptions.");
            logger.error(e.getLocalizedMessage());
        }

        logger.info("Main end............");
    }
}