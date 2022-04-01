package com.jailmango.concurrence.book.core.chapter02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case2_2_16 - 2.2.16 synchronized(Class)代码块对类的所有实例对象都起作用
 *
 * @author jailmango
 * @CreateDate 2019-05-28
 * @see com.jailmango.concurrence.book.core.chapter02
 * @since R9.0
 */
public class Case2_2_16 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case2_2_16.class);

    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        Service service1 = new Service();
        MyThread1 a = new MyThread1("Thread-A", service);
        MyThread2 b = new MyThread2("Thread-B", service1);
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
            service.serviceA();
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
            service.serviceB();
        }
    }

    static class Service {

        public void serviceA() {
            synchronized (Service.class) {
                try {
                    logger.info("Thread[{}] do service A begin... Time[{}]", Thread.currentThread().getName(),
                        System.currentTimeMillis());
                    Thread.sleep(3000);
                    logger.info("Thread[{}] do service A end... Time[{}]", Thread.currentThread().getName(),
                        System.currentTimeMillis());
                }
                catch (InterruptedException e) {
                    logger.error(e.getLocalizedMessage());
                }
            }
        }

        public void serviceB() {
            synchronized (Service.class) {
                logger.info("Thread[{}] do service B begin... Time[{}]", Thread.currentThread().getName(),
                    System.currentTimeMillis());
                logger.info("Thread[{}] do service B end... Time[{}]", Thread.currentThread().getName(),
                    System.currentTimeMillis());
            }
        }
    }
}
