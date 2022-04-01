package com.jailmango.concurrence.book.core.chapter02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case2_2_18_1 - 2.2.18 同步synchronized方法无限等待问题
 *
 * @author jailmango
 * @CreateDate 2019-05-29
 * @see com.jailmango.concurrence.book.core.chapter02
 * @since R9.0
 */
public class Case2_2_18_1 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case2_2_18_1.class);

    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        MyThread1 a = new MyThread1("Thread-A", service);
        MyThread2 b = new MyThread2("Thread-B", service);

        // 模拟问题：线程B永远无法执行，因为线程A与线程B使用同一把锁，且线程A一直持有该锁且未释放
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
            service.serviceA();
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
            service.serviceB();
        }
    }

    static class Service {

        public synchronized void serviceA() {
            logger.info("Thread[{}] do service A begin... Time[{}]", Thread.currentThread().getName(),
                System.currentTimeMillis());

            while (true) {

            }
        }

        public synchronized void serviceB() {
            logger.info("Thread[{}] do service B begin... Time[{}]", Thread.currentThread().getName(),
                System.currentTimeMillis());
            logger.info("Thread[{}] do service B begin... Time[{}]", Thread.currentThread().getName(),
                System.currentTimeMillis());
        }
    }
}
