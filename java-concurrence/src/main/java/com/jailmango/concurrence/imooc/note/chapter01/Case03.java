package com.jailmango.concurrence.imooc.note.chapter01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case03 - Chapter01-03 - 线程间的基础同步设施
 *
 * @author jailmango
 * @CreateDate 2019-02-26
 * @see com.jailmango.imooc.note.chapter01
 * @since R9.0
 */
public class Case03 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case03.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        logger.debug("Main Thread is running...");

        Thread workerA = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                logger.debug("生产螺丝" + (i + 1) + "...");

                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {
                    logger.error(e.getLocalizedMessage());
                }
            }
        });

        Thread workerB = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                logger.debug("生产螺母" + (i + 1) + "...");

                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {
                    logger.error(e.getLocalizedMessage());
                }
            }
        });

        workerA.start();
        workerB.start();

        logger.debug("Main Thread stopped...");
    }
}
