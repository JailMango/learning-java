package com.jailmango.concurrence.book.core.chapter07;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 7.1.2 验证TIMED_WAITING状态
 *
 * @author he.gang33
 * @CreateDate 2020/9/3
 * @see com.jailmango.concurrence.book.core.chapter07
 * @since R9.0
 */
public class Case7_1_2 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case7_1_2.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            try {
                logger.info("begin...");
                Thread.sleep(10000);
                logger.info("end...");
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(1000);
        logger.info("State: [{}]", thread.getState());
    }
}
