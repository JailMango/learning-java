package com.jailmango.concurrence.book.core.chapter07;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 7.2.1 线程对象关联线程组 - 一级关联
 *
 * @author jailmango
 * @CreateDate 2020/9/7
 * @see com.jailmango.concurrence.book.core.chapter07
 * @since R9.0
 */
public class Case7_2_1 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case7_2_1.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Runnable runnable = () -> {
            while (!Thread.currentThread().isInterrupted()) {
                logger.info("doing...");
                try {
                    Thread.sleep(2000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        ThreadGroup group = new ThreadGroup("Thread-Group-HG");
        Thread a = new Thread(group, runnable);
        Thread b = new Thread(group, runnable);
        a.start();
        b.start();

        logger.info("[{}]活动的线程数: [{}]", group.getName(), group.activeCount());
    }
}
