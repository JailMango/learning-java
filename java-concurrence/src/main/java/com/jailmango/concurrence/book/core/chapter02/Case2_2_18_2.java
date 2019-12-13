package com.jailmango.concurrence.book.core.chapter02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case2_2_18_2 - 2.2.18 同步synchronized方法无限等待问题与解决方案，注意同「Case2_2_18_1」的区别
 *
 * @author he.gang33
 * @CreateDate 2019-05-29
 * @see com.jailmango.concurrence.book.core.chapter02
 * @since R9.0
 */
public class Case2_2_18_2 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case2_2_18_2.class);

    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        MyThread1 a = new MyThread1("Thread-A", service);
        MyThread2 b = new MyThread2("Thread-B", service);

        // 解决Case2_2_18_1中的问题，由于线程A与线程B使用不同的锁(不同的Object对象)，解决了无限等待的问题
        a.start();
        Thread.sleep(100);
        b.start();
    }

    static class MyThread1 extends Thread {

        private Service service;

        public MyThread1(String name, Service service) {
            super(name);
            this.service = service;
        }

        @Override
        public void run() {
            service.serviceA(new Object());
        }
    }

    static class MyThread2 extends Thread {

        private Service service;

        public MyThread2(String name, Service service) {
            super(name);
            this.service = service;
        }

        @Override
        public void run() {
            service.serviceB(new Object());
        }
    }

    static class Service {

        public void serviceA(Object obj) {
            synchronized (obj) {
                logger.info("Thread[{}] do service A begin... Time[{}]", Thread.currentThread().getName(),
                    System.currentTimeMillis());

                while (true) {

                }
            }
        }

        public void serviceB(Object obj) {
            synchronized (obj) {
                logger.info("Thread[{}] do service B begin... Time[{}]", Thread.currentThread().getName(),
                    System.currentTimeMillis());
                logger.info("Thread[{}] do service B begin... Time[{}]", Thread.currentThread().getName(),
                    System.currentTimeMillis());
            }
        }
    }
}
