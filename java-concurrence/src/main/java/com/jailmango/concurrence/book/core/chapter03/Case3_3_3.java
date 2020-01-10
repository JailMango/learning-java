package com.jailmango.concurrence.book.core.chapter03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case3_3_3 - 3.3.3 验证线程变量的隔离性
 * 运行结果表明，通过使用ThreadLocal实现每个线程存储自己的私有数据
 * 
 * @author he.gang33
 * @CreateDate 2019/12/19
 * @see com.jailmango.concurrence.book.core.chapter03
 * @since R9.0
 */
public class Case3_3_3 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case3_3_3.class);

    /**
     * main
     * 
     * @param args String[]
     * @throws InterruptedException InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        ThreadA a = new ThreadA();
        ThreadB b = new ThreadB();

        a.start();
        b.start();

        for (int i = 0; i < 10; i++) {
            Data.threadLocal.set("main" + (i + 1));
            logger.info("Main -> {}", Data.threadLocal.get());

            int sleepValue = (int) (Math.random() * 500);
            Thread.sleep(sleepValue);
        }
    }

    private static class ThreadA extends Thread {

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    Data.threadLocal.set("A" + (i + 1));
                    logger.info("Thread A -> {}", Data.threadLocal.get());

                    int sleepValue = (int) (Math.random() * 500);
                    Thread.sleep(sleepValue);

                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class ThreadB extends Thread {

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    Data.threadLocal.set("B" + (i + 1));
                    logger.info("Thread B -> {}", Data.threadLocal.get());

                    int sleepValue = (int) (Math.random() * 500);
                    Thread.sleep(sleepValue);

                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class Data {

        /**
         * threadLocal
         */
        public static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    }
}
