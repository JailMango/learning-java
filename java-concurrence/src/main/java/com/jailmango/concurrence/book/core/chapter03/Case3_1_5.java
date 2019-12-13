package com.jailmango.concurrence.book.core.chapter03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case3_1_5 - 3.1.5 完整实现wait/notify机制
 *
 * @author he.gang33
 * @CreateDate 2019-05-31
 * @see com.jailmango.concurrence.book.core.chapter03
 * @since R9.0
 */
public class Case3_1_5 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case3_1_5.class);

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        MyThread1 a = new MyThread1("Thread-A", lock);
        MyThread2 b = new MyThread2("Thread-B", lock);

        a.start();
        Thread.sleep(2000);
        b.start();

        // 本例中, wait状态的线程被notify
    }

    static class MyThread1 extends Thread {

        private Object lock;

        public MyThread1(String name, Object lock) {
            super(name);
            this.lock = lock;
        }

        @Override
        public void run() {
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
    }

    static class MyThread2 extends Thread {
        private Object lock;

        public MyThread2(String name, Object lock) {
            super(name);
            this.lock = lock;
        }

        @Override
        public void run() {
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
