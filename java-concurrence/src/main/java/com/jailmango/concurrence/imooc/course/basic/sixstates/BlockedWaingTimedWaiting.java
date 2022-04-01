package com.jailmango.concurrence.imooc.course.basic.sixstates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * BlockedWaingTimedWaiting <br/>
 * 展示Blocked、Waiting、TimedWaiting状态
 *
 * @author jailmango
 * @CreateDate 2020/4/30
 * @see com.jailmango.concurrence.imooc.course.basic.sixstates
 * @since R9.0
 */
public class BlockedWaingTimedWaiting implements Runnable {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(BlockedWaingTimedWaiting.class);

    public static void main(String[] args) {
        BlockedWaingTimedWaiting runnable = new BlockedWaingTimedWaiting();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();

        // 若不加主线程sleep，有可能会出现RUNNABLE
        try {
            // 留一段时间给其他线程执行，可以显示TIMED_WAITING
            Thread.sleep(5);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("Thread-1 State: [{}]", thread1.getState());
        logger.info("Thread-2 State: [{}]", thread2.getState());

        // 若不加主线程sleep，有可能会出现RUNNABLE
        try {
            // 留一段时间给其他线程执行，可以显示TIMED_WAITING
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        logger.info("Thread-1 State: [{}]", thread1.getState());
        logger.info("Thread-2 State: [{}]", thread2.getState());
    }

    @Override
    public void run() {
        syn();
    }

    private synchronized void syn() {
        try {
            logger.info("Thread[{}] sleeping...", Thread.currentThread().getName());
            Thread.sleep(1000);
            wait();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
