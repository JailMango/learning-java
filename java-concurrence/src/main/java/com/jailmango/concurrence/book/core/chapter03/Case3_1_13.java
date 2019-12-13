package com.jailmango.concurrence.book.core.chapter03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case3_1_13
 *
 * @author he.gang33
 * @CreateDate 2019-06-03
 * @see com.jailmango.concurrence.book.core.chapter03
 * @since R9.0
 */
public class Case3_1_13 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case3_1_13.class);

    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();

        MyThreadA[] waitArr = new MyThreadA[10];

        for (int i = 0; i < 10; i++) {
            waitArr[i] = new MyThreadA("Wait-" + i, service);
        }

        MyThreadB[] notifyArr = new MyThreadB[5];

        for (int i = 0; i < 5; i++) {
            notifyArr[i] = new MyThreadB("Notify-" + i, service);
        }

        for (MyThreadA thread : waitArr) {
            thread.start();
        }

        for (MyThreadB thread : notifyArr) {
            thread.start();
            Thread.sleep(500);
        }

        // notify()方法仅按照执行wait()方法的顺序，依次唤醒一个线程。
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
                lock.notify();
                logger.info("Thread[{}] notify end... Time[{}]", Thread.currentThread().getName(),
                    System.currentTimeMillis());
            }
        }
    }
}
