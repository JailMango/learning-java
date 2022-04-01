package com.jailmango.concurrence.book.core.chapter02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case2_2_14_1
 *
 * @author jailmango
 * @CreateDate 2019-05-27
 * @see com.jailmango.concurrence.book.core.chapter01
 * @since R9.0
 */
public class Case2_2_14_1 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case2_2_14_1.class);

    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        MyThread1 a = new MyThread1("Thread-A", service);
        MyThread2 b = new MyThread2("Thread-B", service);
        MyThread3 c = new MyThread3("Thread-C", service);

        // 通过实现可以看出，线程A与线程C没有呈现同步效果。因为synchronized静态方法的锁对象是类对象。而synchronized实例方法的锁对象是类的实例对象。不是同一把锁。

        a.start();
        Thread.sleep(100);
        c.start();
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
            Service.serviceA();
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
            Service.serviceB();
        }
    }

    static class MyThread3 extends Thread {

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
        public MyThread3(String name, Service service) {
            super(name);
            this.service = service;
        }

        @Override
        public void run() {
            service.serviceC();
        }
    }

    static class Service {
        public static synchronized void serviceA() {
            try {
                logger.info("Thread[{}] do service A begin... Time[{}]", Thread.currentThread().getName(),
                    System.currentTimeMillis());
                Thread.sleep(4000);
                logger.info("Thread[{}] do service A end... Time[{}]", Thread.currentThread().getName(),
                    System.currentTimeMillis());
            }
            catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }
        }

        public static synchronized void serviceB() {
            try {
                logger.info("Thread[{}] do service B begin... Time[{}]", Thread.currentThread().getName(),
                    System.currentTimeMillis());
                Thread.sleep(500);
                logger.info("Thread[{}] do service B end... Time[{}]", Thread.currentThread().getName(),
                    System.currentTimeMillis());
            }
            catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }
        }

        public synchronized void serviceC() {
            try {
                logger.info("Thread[{}] do service C begin... Time[{}]", Thread.currentThread().getName(),
                    System.currentTimeMillis());
                Thread.sleep(2000);
                logger.info("Thread[{}] do service C end... Time[{}]", Thread.currentThread().getName(),
                    System.currentTimeMillis());
            }
            catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }
        }
    }
}
