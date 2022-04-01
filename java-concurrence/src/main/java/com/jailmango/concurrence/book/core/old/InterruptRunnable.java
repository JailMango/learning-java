package com.jailmango.concurrence.book.core.old;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * InterruptRunnable
 *
 * @author jailmango
 * @CreateDate 2018-11-28
 * @see com.jailmango.java.book.core.chapter01
 * @since R9.0<br>
 */
public class InterruptRunnable implements Runnable {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(InterruptRunnable.class);

    /**
     * count
     */
    private int count = 0;

    @Override
    public void run() {
        while (count < 1000) {
            logger.info("doing job -> " + count++);
        }
    }
}
