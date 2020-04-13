package com.jailmango.concurrence.book.core.chapter04;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case4_1_8 - 4.1.8 实现生产者/消费者模式一对一交替输出
 *
 * @author he.gang33
 * @CreateDate 2020/1/14
 * @see com.jailmango.concurrence.book.core.chapter04
 * @since R9.0
 */
public class Case4_1_8 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case4_1_8.class);

    public static void main(String[] args) {
        MyService myService = new MyService();
        ThreadA a = new ThreadA(myService);
        a.start();

        ThreadB b = new ThreadB(myService);
        b.start();
    }

    private static class MyService {

        /**
         * ReentrantLock
         */
        private ReentrantLock lock = new ReentrantLock();

        /**
         * Condition
         */
        private Condition condition = lock.newCondition();

        /**
         * hasValue
         */
        private boolean hasValue = false;

        /**
         * set
         */
        public void set() {
            lock.lock();

            try {
                Thread.sleep(300);
                if (hasValue) {
                    condition.await();
                }
                logger.info("★★★★★");
                hasValue = true;
                condition.signal();
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
         * get
         */
        public void get() {
            lock.lock();

            try {
                Thread.sleep(300);
                if (!hasValue) {
                    condition.await();
                }
                logger.info("☆☆☆☆☆");
                hasValue = false;
                condition.signal();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
                logger.error("catch InterruptedException...");
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
            for (int i = 0; i < 100; i++) {
                myService.set();
            }
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
            for (int i = 0; i < 100; i++) {
                myService.get();
            }
        }
    }

}
