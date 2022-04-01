package com.jailmango.concurrence.book.core.old;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * MainInterrupt
 *
 * @author jailmango
 * @CreateDate 2018-11-28
 * @see com.jailmango.java.book.core.chapter01
 * @since R9.0<br>
 */
public class MainInterrupt {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(MainInterrupt.class);

    /**
     * main
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        logger.info("main start...");
        Thread.currentThread().interrupt();

        logger.info("是否停止? - 1 -> " + Thread.interrupted());
        logger.info("是否停止? - 2 -> " + Thread.interrupted());
        logger.info("main end...");
    }
}
