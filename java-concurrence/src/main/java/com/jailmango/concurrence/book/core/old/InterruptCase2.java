package com.jailmango.concurrence.book.core.old;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * InterruptCase2
 *
 * @author jailmango
 * @CreateDate 2018-11-28
 * @see com.jailmango.java.book.core.chapter01
 * @since R9.0<br>
 */
public class InterruptCase2 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(InterruptCase2.class);

    /**
     * main
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        try {
            Thread thread = new Thread(new InterruptRunnable());
            thread.start();
            Thread.sleep(1000);
            thread.interrupt();
            logger.info(" 是否 停止 1？=" + thread.isInterrupted());
            logger.info(" 是否 停止 2？=" + thread.isInterrupted());
        }
        catch (InterruptedException e) {
            logger.info(" main catch");
            logger.info(e.getLocalizedMessage());
        }

        logger.info(" end!");
    }

}
