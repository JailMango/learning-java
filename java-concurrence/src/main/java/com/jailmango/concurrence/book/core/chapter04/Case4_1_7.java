package com.jailmango.concurrence.book.core.chapter04;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case4_1_7 - 4.1.7 通知部分线程-正确用法
 * 本例通知了线程A，未通知线程B
 * @author jailmango
 * @CreateDate 2020/1/14
 * @see com.jailmango.concurrence.book.core.chapter04
 * @since R9.0
 */
public class Case4_1_7 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case4_1_7.class);

    /**
     * main
     * 
     * @param args String[]
     * @throws InterruptedException InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        MyService myService = new MyService();
        ThreadA a = new ThreadA(myService);
        ThreadB b = new ThreadB(myService);

        a.start();
        b.start();

        Thread.sleep(3000);

        myService.signalAllA();
    }

    private static class MyService {

        /**
         * ReentrantLock
         */
        private ReentrantLock lock = new ReentrantLock();

        /**
         * Condition
         */
        private Condition conditionA = lock.newCondition();

        /**
         * Condition
         */
        private Condition conditionB = lock.newCondition();

        /**
         * awaitA
         */
        public void awaitA() {
            lock.lock();

            try {
                logger.info("await a begin...{}", System.currentTimeMillis());
                conditionA.await();
                logger.info("await a begin...{}", System.currentTimeMillis());
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
         * awaitB
         */
        public void awaitB() {
            lock.lock();

            try {
                logger.info("await b begin...{}", System.currentTimeMillis());
                conditionB.await();
                logger.info("await b begin...{}", System.currentTimeMillis());
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
         * 通知A
         */
        public void signalAllA() {
            lock.lock();

            try {
                logger.info("signalAll a...{}", System.currentTimeMillis());
                conditionA.signalAll();
            }
            finally {
                lock.unlock();
            }
        }

        /**
         * 通知B
         */
        public void signalAllB() {
            lock.lock();

            try {
                logger.info("signallAll b...{}", System.currentTimeMillis());
                conditionB.signalAll();
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
        private MyService myService;

        /**
         * Constructor
         * 
         * @param myService MyService
         */
        public ThreadA(MyService myService) {
            this.myService = myService;
        }

        @Override
        public void run() {
            myService.awaitA();
        }
    }

    private static class ThreadB extends Thread {

        /**
         * MyService
         */
        private MyService myService;

        /**
         * Constructor
         * 
         * @param myService MyService
         */
        public ThreadB(MyService myService) {
            this.myService = myService;
        }

        @Override
        public void run() {
            myService.awaitB();
        }
    }
}
