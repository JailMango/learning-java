package com.jailmango.concurrence.book.core.chapter03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case3_1_12 - 3.1.12 interrupt()方法遇到wait()方法
 *
 * @author he.gang33
 * @CreateDate 2019-06-03
 * @see com.jailmango.concurrence.book.core.chapter03
 * @since R9.0
 */
public class Case3_1_12 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case3_1_12.class);

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        MyThread a = new MyThread("Thread-A", lock);

        a.start();
        Thread.sleep(2000);
        a.interrupt();
    }

    static class MyThread extends Thread {

        private Object lock;

        public MyThread(String name, Object lock) {
            super(name);
            this.lock = lock;
        }

        @Override
        public void run() {
            Service service = new Service();
            service.doService(lock);
        }
    }

    static class Service {

        public void doService(Object lock) {
            try {
                synchronized (lock) {
                    logger.info("Thread[{}] begin wait... Time[{}]", Thread.currentThread().getName(),
                        System.currentTimeMillis());
                    lock.wait();
                    logger.info("Thread[{}] end wait... Time[{}]", Thread.currentThread().getName(),
                        System.currentTimeMillis());
                }
            }
            catch (InterruptedException e) {
                logger.error("Catch Interrupted Exception...");
                e.printStackTrace();
            }
        }
    }
}
