package com.jailmango.concurrence.book.core.chapter02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case2_3_1_5_1 - 2.3.1 - 5. synchronized{}代码块具有增加可见性的作用(反例)
 *
 * @author jailmango
 * @CreateDate 2019-05-30
 * @see com.jailmango.concurrence.book.core.chapter02
 * @since R9.0
 */
public class Case2_3_1_5_1 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case2_3_1_5_1.class);

    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        MyThread1 a = new MyThread1("Thread-A", service);
        MyThread2 b = new MyThread2("Thread-B", service);

        // 本例出现死循环，原因是因为线程间的数据没有可见性
        a.start();
        Thread.sleep(100);
        b.start();
    }

    static class MyThread1 extends Thread {

        /**
         * Service
         */
        private Service service;

        /**
         * Constructor
         * 
         * @param name String
         * @param service Service
         */
        public MyThread1(String name, Service service) {
            super(name);
            this.service = service;
        }

        @Override
        public void run() {
            service.runMethod();
        }
    }

    static class MyThread2 extends Thread {

        /**
         * Service
         */
        private Service service;

        /**
         * Constructor
         * 
         * @param name String
         * @param service Service
         */
        public MyThread2(String name, Service service) {
            super(name);
            this.service = service;
        }

        @Override
        public void run() {
            service.stopMethod();
        }
    }

    static class Service {

        private boolean isFinished = false;

        public void runMethod() {
            logger.info("Thread[{}] run method begin...", Thread.currentThread().getName());
            while (!isFinished) {

            }
            logger.info("Thread[{}] run method end...", Thread.currentThread().getName());
        }

        public void stopMethod() {
            isFinished = true;
            logger.info("Thread[{}] set is finished is false", Thread.currentThread().getName());
        }

    }
}
