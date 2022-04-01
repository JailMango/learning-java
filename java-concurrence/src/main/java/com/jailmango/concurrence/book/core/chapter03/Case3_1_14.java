package com.jailmango.concurrence.book.core.chapter03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case3_1_14 - 3.1.14 notifyAll()方法，通知所有线程
 *
 * @author jailmango
 * @CreateDate 2019-06-03
 * @see com.jailmango.concurrence.book.core.chapter03
 * @since R9.0
 */
public class Case3_1_14 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case3_1_14.class);

    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();

        MyThreadA[] waitArr = new MyThreadA[10];
        for (int i = 0; i < 10; i++) {
            waitArr[i] = new MyThreadA("Wait-" + i, service);
        }

        for (MyThreadA thread : waitArr) {
            thread.start();
        }

        Thread.sleep(2000);

        MyThreadB notifyThread = new MyThreadB("Notify-All", service);
        notifyThread.start();

        // notifyAll()方法会按照执行wait()方法的倒序，依次对其他线程进行唤醒。
        // 注意与Case3_1_13中的notify()的区别。(唤醒顺序 和 唤醒个数)
    }

    static class MyThreadA extends Thread {

        private Service service;

        public MyThreadA(String name, Service service) {
            super(name);
            this.service = service;
        }

        @Override
        public void run() {
            service.waitMethod();
        }
    }

    static class MyThreadB extends Thread {

        private Service service;

        public MyThreadB(String name, Service service) {
            super(name);
            this.service = service;
        }

        @Override
        public void run() {
            service.notifyMethod();
        }
    }

    static class Service {

        private Object lock = new Object();

        public void waitMethod() {
            try {
                synchronized (lock) {
                    logger.info("Thread[{}] wait begin... Time[{}]", Thread.currentThread().getName(),
                        System.currentTimeMillis());
                    lock.wait();
                    logger.info("Thread[{}] wait end... Time[{}]", Thread.currentThread().getName(),
                        System.currentTimeMillis());
                }
            }
            catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }
        }

        public void notifyMethod() {
            synchronized (lock) {
                logger.info("Thread[{}] notify begin... Time[{}]", Thread.currentThread().getName(),
                    System.currentTimeMillis());
                lock.notifyAll();
                logger.info("Thread[{}] notify end... Time[{}]", Thread.currentThread().getName(),
                    System.currentTimeMillis());
            }
        }
    }
}
