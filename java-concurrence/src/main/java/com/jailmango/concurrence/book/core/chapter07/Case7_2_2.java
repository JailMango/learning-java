package com.jailmango.concurrence.book.core.chapter07;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 7.2.2 线程对象关联线程组：多级关联
 *
 * @author jailmango
 * @CreateDate 2020/9/7
 * @see com.jailmango.concurrence.book.core.chapter07
 * @since R9.0
 */
public class Case7_2_2 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case7_2_2.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        logger.info("main主线程所在线程组[{}]活动线程数[{}]", mainGroup.getName(), mainGroup.activeCount());
        // main线程组的父线程组是system
        logger.info("main线程组所在线程组[{}]", mainGroup.getParent().getName());

        ThreadGroup group = new ThreadGroup(mainGroup, "Group-1");
        logger.info("[{}]活动线程数[{}]", group.getName(), group.activeCount());

        Runnable runnable = () -> {
            try {
                logger.info("doing...");
                Thread.sleep(5000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread a = new Thread(group, runnable);
        a.setName("Thread-A");
        a.start();
        Thread.sleep(1000);
        logger.info("[{}]活动线程数[{}]", group.getName(), group.activeCount());

        ThreadGroup[] groups = new ThreadGroup[Thread.currentThread().getThreadGroup().activeGroupCount()];
        Thread.currentThread().getThreadGroup().enumerate(groups);
        logger.info("main线程中有[{}]个线程组", groups.length);
        for (int i = 0; i < groups.length; i++) {
            logger.info("线程组[{}]活动线程数[{}]", groups[i].getName(), groups[i].activeCount());
            Thread[] threads = new Thread[groups[i].activeCount()];
            groups[i].enumerate(threads);
            for (int m = 0; m < threads.length; m++) {
                logger.info("线程[{}]状态[{}]", threads[m].getName(), threads[m].getState());
            }
        }
    }
}
