package com.jailmango.concurrence.book.core.chapter04;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case4_1_9 - 4.1.9 实现生产者/消费者模式多对多交替输出
 *
 * @author jailmango
 * @CreateDate 2020/1/17
 * @see com.jailmango.concurrence.book.core.chapter04
 * @since R9.0
 */
public class Case4_1_9 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case4_1_9.class);

    public static void main(String[] args) {
        MyService service = new MyService();
        ThreadA[] a = new ThreadA[10];
        ThreadB[] b = new ThreadB[10];

        for (int i = 0; i < 10; i++) {
            a[i] = new ThreadA(service);
            b[i] = new ThreadB(service);
        }

        for (int i = 0; i < 10; i++) {
            a[i].start();
            b[i].start();
        }

    }

    private static class MyService {

        /**
         * ReentrantLock
         */
        private ReentrantLock lock = new ReentrantLock();

        /**
         * Condtion
         */
        private Condition condition = lock.newCondition();

        /**
         * hasValue
         */
        private boolean hasValue = false;

        public void set() {
            lock.lock();

            try {
                Thread.sleep(200);
                while (hasValue) {
                    logger.info("set() wait...");
                    condition.await();
                }

                logger.info("★★★★★");
                hasValue = true;

                condition.signalAll();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }
        }

        private void get() {
            lock.lock();

            try {
                Thread.sleep(200);
                while (!hasValue) {
                    logger.info("get() wait...");
                    condition.await();
                }

                logger.info("☆☆☆☆☆");
                hasValue = false;

                condition.signalAll();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
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

        public ThreadA(MyService myService) {
            this.myService = myService;
        }

        @Override
        public void run() {
            myService.set();
        }
    }

    private static class ThreadB extends Thread {

        /**
         * MyService
         */
        private MyService myService;

        public ThreadB(MyService myService) {
            this.myService = myService;
        }

        @Override
        public void run() {
            myService.get();
        }
    }

}