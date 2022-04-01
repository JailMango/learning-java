package com.jailmango.concurrence.book.core.chapter02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case2_2_17 - 2.2.17 String常量池特性与同步相关的问题与解决方案
 *
 * @author jailmango
 * @CreateDate 2019-05-28
 * @see com.jailmango.concurrence.book.core.chapter02
 * @since R9.0
 */
public class Case2_2_17 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case2_2_17.class);

    public static void main(String[] args) throws InterruptedException {
        MyThread1 a = new MyThread1("Thread-A");
        MyThread2 b = new MyThread2("Thread-B");

        // 说明String用的是常量池
        a.start();
        Thread.sleep(100);
        b.start();
    }

    static class MyThread1 extends Thread {

        public MyThread1(String name) {
            super(name);
        }

        @Override
        public void run() {
            Service.serviceA("AA");
        }
    }

    static class MyThread2 extends Thread {

        public MyThread2(String name) {
            super(name);
        }

        @Override
        public void run() {
            Service.serviceA("AA");
        }
    }

    static class Service {

        public static void serviceA(String param) {
            try {
                synchronized (param) {
                    logger.info("Thread[{}] do service A begin... Time[{}]", Thread.currentThread().getName(),
                        System.currentTimeMillis());
                    Thread.sleep(3000);
                    logger.info("Thread[{}] do service A end... Time[{}]", Thread.currentThread().getName(),
                        System.currentTimeMillis());
                }
            }
            catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }
        }

        public static void serviceB(String param) {
            try {
                synchronized (param) {
                    logger.info("Thread[{}] do service B begin... Time[{}]", Thread.currentThread().getName(),
                        System.currentTimeMillis());
                    Thread.sleep(1000);
                    logger.info("Thread[{}] do service B end... Time[{}]", Thread.currentThread().getName(),
                        System.currentTimeMillis());
                }
            }
            catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }
        }
    }
}
