package com.jailmango.concurrence.book.core.chapter07;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case7_2_6
 *
 * @author he.gang33
 * @CreateDate 2020/9/7
 * @see com.jailmango.concurrence.book.core.chapter07
 * @since R9.0
 */
public class Case7_2_6 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case7_2_6.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            logger.info("prepare...");
            while (!Thread.currentThread().isInterrupted()) {
                logger.info("doing...");
            }
            logger.info("end...");
        };
        ThreadGroup group = new ThreadGroup("New-Group");

        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(group, runnable);
            thread.setName("New-Thread-" + (i + 1));
            thread.start();
        }

        Thread.sleep(1000);

        group.interrupt();
        logger.info("call group.interrupt()...");
    }

}
