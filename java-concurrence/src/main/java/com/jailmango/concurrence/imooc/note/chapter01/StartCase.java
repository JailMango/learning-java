package com.jailmango.concurrence.imooc.note.chapter01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * StartCase - 开篇 - 什么是线程
 *
 * @author jailmango
 * @CreateDate 2019-02-26
 * @see com.jailmango.imooc.note.chapter01
 * @since R9.0
 */
public class StartCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(StartCase.class);

    /**
     * name
     */
    private static final String THREAD_NAME = "sub-thread";

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        // 创建线程的两种方式
        // 实现Runnable接口
        // 使用了lambda表达式，等价于 new Thread(new Runnable() {...});
        Thread thread1 = new Thread(() -> {
            logger.debug("Runnable Thread[" + Thread.currentThread().getName() + "] is running...");

            try {
                Thread.sleep(200000);
            }
            catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }
        }, THREAD_NAME);

        thread1.start();

        logger.debug("Thread[" + Thread.currentThread().getName() + "] is running...");

        try {
            Thread.sleep(200000);
        }
        catch (InterruptedException e) {
            logger.error(e.getLocalizedMessage());
        }
    }

    static class MyThread extends Thread {

        /**
         * logger
         */
        private static final Logger logger = LoggerFactory.getLogger(MyThread.class);

        /**
         * Constructor
         * 
         * @param name String
         */
        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            logger.debug("Extends Thread[" + Thread.currentThread().getName() + "] is Running...");

            try {
                Thread.sleep(200000);
            }
            catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }
        }
    }
}
