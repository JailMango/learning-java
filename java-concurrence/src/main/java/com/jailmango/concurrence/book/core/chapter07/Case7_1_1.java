package com.jailmango.concurrence.book.core.chapter07;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 7.1.1 验证线程状态NEW, RUNNABLE, TERMINATED
 *
 * @author he.gang33
 * @CreateDate 2020/9/2
 * @see com.jailmango.concurrence.book.core.chapter07
 * @since R9.0
 */
public class Case7_1_1 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case7_1_1.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        MyThread th1 = new MyThread();
        logger.info("main方法中的状态1: [{}]", th1.getState());
        Thread.sleep(1000);
        th1.start();
        Thread.sleep(1000);
        logger.info("main方法中的状态2: [{}]", th1.getState());
    }

    private static class MyThread extends Thread {

        public MyThread() {
            logger.info("构造方法中的状态 Thread.currentThread().getState(): [{}]", Thread.currentThread().getState());
            logger.info("构造方法中的状态 this..getState: [{}]", this.getState());
        }

        @Override
        public void run() {
            logger.info("run方法中的状态 Thread.currentThread().getState(): [{}]", Thread.currentThread().getState());
        }
    }
}
