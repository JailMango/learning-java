package com.jailmango.concurrence.book.core.chapter04;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case4_1_6 - 4.1.6 通知部分线程-错误用法
 * 本例使用了一个contion对象，因此唤醒了所有线程
 * @author jailmango
 * @CreateDate 2020/1/13
 * @see com.jailmango.concurrence.book.core.chapter04
 * @since R9.0
 */
public class Case4_1_6 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case4_1_6.class);

    /**
     * main
     * 
     * @param args String[]
     * @throws InterruptedException InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();
        ThreadA a = new ThreadA(service);
        ThreadB b = new ThreadB(service);

        a.start();
        b.start();

        Thread.sleep(3000);

        service.signalAll();
    }

    private static class MyService {

        /**
         * ReentrantLock
         */
        private Lock lock = new ReentrantLock();

        /**
         * Condition
         */
        private Condition condition = lock.newCondition();

        /**
         * awaitA
         */
        public void awaitA() {
            lock.lock();

            try {
                logger.info("await a begin...{}", System.currentTimeMillis());
                condition.await();
                logger.info("await a end...{}", System.currentTimeMillis());
            }
            catch (InterruptedException e) {
                e.printStackTrace();
                logger.info("catch InterruptedException...");
            }
            finally {
                lock.unlock();
            }
        }

        /**
         * awaitB
         */
        public void awaitB() {
            lock.lock();

            try {
                logger.info("await b begin...{}", System.currentTimeMillis());
                condition.await();
                logger.info("await b end...{}", System.currentTimeMillis());
            }
            catch (InterruptedException e) {
                e.printStackTrace();
                logger.error("catch InterruptedException...");
            }
            finally {
                lock.unlock();
            }
        }

        /**
         * sginalAll
         */
        public void signalAll() {
            lock.lock();

            try {
                logger.info("signalAll...{}", System.currentTimeMillis());
                condition.signalAll();
            }
            finally {
                lock.unlock();
            }
        }
    }

    private static class ThreadA extends Thread {

        /**
         * MyService
         */
        private MyService service;

        /**
         * Constructor
         * 
         * @param service MyService
         */
        public ThreadA(MyService service) {
            this.service = service;
        }

        @Override
        public void run() {
            service.awaitA();
        }
    }

    private static class ThreadB extends Thread {

        /**
         * MyService
         */
        private MyService service;

        /**
         * Constructor
         * 
         * @param service MyService
         */
        public ThreadB(MyService service) {
            this.service = service;
        }

        @Override
        public void run() {
            service.awaitB();
        }
    }
}
