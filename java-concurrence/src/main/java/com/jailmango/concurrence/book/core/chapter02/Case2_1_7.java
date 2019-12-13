package com.jailmango.concurrence.book.core.chapter02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case2_1_7
 *
 * @author he.gang33
 * @CreateDate 2019-05-23
 * @see com.jailmango.concurrence.book.core.chapter02
 * @since R9.0
 */
public class Case2_1_7 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case2_1_7.class);

    public static void main(String[] args) {
        Service service = new Service();
        MyThread thread = new MyThread(service);
        // synchronized具有「可重入锁」的功能。「可重入锁」是指自己可以再次获得自己内部的锁。
        // 这边可以连续的调用service1(), service2()和service3()，可以看出synchronized具有可重入锁的功能
        thread.start();
    }

    static class MyThread extends Thread {

        /**
         * Service
         */
        private Service service;

        /**
         * Constructor
         * 
         * @param service Service
         */
        public MyThread(Service service) {
            this.service = service;
        }

        @Override
        public void run() {
            service.service1();
        }
    }

    static class Service {

        public synchronized void service1() {
            logger.info("Thread[{}] do service1...", Thread.currentThread().getName());
            service2();
        }

        public synchronized void service2() {
            logger.info("Thread[{}] do service2...", Thread.currentThread().getName());
            service3();
        }

        public synchronized void service3() {
            logger.info("Thread[{}] do service3...", Thread.currentThread().getName());
        }
    }
}
