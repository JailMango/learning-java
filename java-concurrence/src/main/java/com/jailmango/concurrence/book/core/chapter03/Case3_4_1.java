package com.jailmango.concurrence.book.core.chapter03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case3_4_1 - 3.4.1 类ThreadLocal不能实现值继承
 *
 * @author he.gang33
 * @CreateDate 2019/12/20
 * @see com.jailmango.concurrence.book.core.chapter03
 * @since R9.0
 */
public class Case3_4_1 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case3_4_1.class);

    /**
     * main
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        // main线程中创建了ThreadA线程，所以main线程是ThreadA线程的父线程
        try {
            for (int i = 0; i < 10; i++) {
                if (null == Data.threadLocal.get()) {
                    Data.threadLocal.set("此值是main线程放入的...");
                }
                logger.info("Main -> {}", Data.threadLocal.get());
                Thread.sleep(100);
            }
            Thread.sleep(5000);

            ThreadA a = new ThreadA();
            a.start();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class ThreadA extends Thread {

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    logger.info("Thread A -> {}", Data.threadLocal.get());
                    Thread.sleep(100);
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class Data {

        /**
         * ThreadLocal
         */
        public static ThreadLocal threadLocal = new ThreadLocal();
    }
}
