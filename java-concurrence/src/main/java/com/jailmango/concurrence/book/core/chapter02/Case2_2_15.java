package com.jailmango.concurrence.book.core.chapter02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case2_2_15
 *
 * @author he.gang33
 * @CreateDate 2019-05-27
 * @see com.jailmango.concurrence.book.core.chapter02
 * @since R9.0
 */
public class Case2_2_15 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case2_2_15.class);

    public static void main(String[] args) throws InterruptedException {
        Service serviceA = new Service();
        Service serviceB = new Service();
        MyThread1 a = new MyThread1("Thread-A", serviceA);
        MyThread2 b = new MyThread2("Thread-B", serviceB);

        // 实验结果可以看出，线程A与线程B还是呈现同步效果。因为synchronized静态方法，锁对象是类对象(Class对象是单例的)。
        // 虽然Service实例不同，但是还是同一把锁，因此还是呈现同步效果。
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

        public static synchronized void serviceA() {
            try {
                logger.info("Thread[{}] do service A begin... Time[{}]", Thread.currentThread().getName(),
                    System.currentTimeMillis());
                Thread.sleep(2000);
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
    }
}
