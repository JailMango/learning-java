package com.jailmango.concurrence.book.core.old;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SleepCase
 *
 * @author jailmango
 * @CreateDate 2018-11-28
 * @see com.jailmango.java.book.core.chapter01
 * @since R9.0<br>
 */
public class SleepCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(SleepCase.class);

    public static void main(String[] args) {
        logger.info("Main begin...");
        try {
            Thread thread = new Thread(new SleepRunnable());
            thread.start();
            Thread.sleep(2000);
            thread.interrupt();
        }
        catch (InterruptedException e) {
            logger.info("Main catch...");
            logger.error(e.getLocalizedMessage());
        }
        logger.info("Main end...");
    }
}
