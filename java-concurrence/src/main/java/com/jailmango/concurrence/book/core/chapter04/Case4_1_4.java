package com.jailmango.concurrence.book.core.chapter04;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case4_1_4 - 4.1.4 使用await()和signal()使用wait/notify机制
 * 从例子可以看出，main线程通知了MyThread线程
 *
 * @author he.gang33
 * @CreateDate 2020/1/10
 * @see com.jailmango.concurrence.book.core.chapter04
 * @since R9.0
 */
public class Case4_1_4 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case4_1_4.class);

    /**
     * main
     * 
     * @param args String[]
     * @throws InterruptedException InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        MyThread thread = new MyThread(service);
        thread.start();

        logger.info("wait 2000ms...");
        Thread.sleep(2000);

        service.signal();
    }

    private static class MyThread extends Thread {

        /**
         * Service
         */
        private Service service;

        /**
         * Constructor
         * 
         * @param service
         */
        public MyThread(Service service) {
            this.service = service;
        }

        @Override
        public void run() {
            service.await();
        }
    }

    private static class Service {

        /**
         * ReentrantLock
         */
        private ReentrantLock lock = new ReentrantLock();

        /**
         * Condition
         */
        private Condition condition = lock.newCondition();

        /**
         * await
         */
        public void await() {
            lock.lock();
            try {
                logger.info("await before...");
                condition.await();
                logger.info("await after...");
            }
            catch (InterruptedException e) {
                logger.error("catch InterruptedException...");
                e.printStackTrace();
            }
            finally {
                lock.unlock();
                logger.info("await -> unlock...");
            }
        }

        /**
         * signal
         */
        public void signal() {
            lock.lock();
            try {
                logger.info("signal before...");
                condition.signal();
                logger.info("signal after...");
            }
            finally {
                lock.unlock();
                logger.info("signal -> unlock...");
            }
        }
    }
}
