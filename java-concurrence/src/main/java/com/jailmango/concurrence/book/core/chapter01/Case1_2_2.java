package com.jailmango.concurrence.book.core.chapter01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case1_2_2 - 1.2.2 分析线程的指令
 *
 * @author he.gang33
 * @CreateDate 2019-05-16
 * @see com.jailmango.concurrence.book.core.chapter01
 * @since R9.0
 */
public class Case1_2_2 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case1_2_2.class);

    /**
     * main
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                logger.info(Thread.currentThread().getName() + " running...");
                try {
                    Thread.sleep(1000000);
                }
                catch (InterruptedException e) {
                    logger.info(e.getMessage());
                }
            }).start();
        }
    }
}
