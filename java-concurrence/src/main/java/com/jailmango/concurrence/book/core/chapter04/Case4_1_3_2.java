package com.jailmango.concurrence.book.core.chapter04;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case4_1_3_2 - 4.1.3 await()方法的错误使用与更正
 *
 * @author jailmango
 * @CreateDate 2020/1/6
 * @see com.jailmango.concurrence.book.core.chapter04
 * @since R9.0
 */
public class Case4_1_3_2 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case4_1_3_2.class);

    public static void main(String[] args) {
        Service service = new Service();
        MyThread a = new MyThread(service);
        MyThread b = new MyThread(service);
        MyThread c = new MyThread(service);

        a.start();
        b.start();
        c.start();
    }

    private static class MyThread extends Thread {

        private Service service;

        public MyThread(Service service) {
            this.service = service;
        }

        @Override
        public void run() {
            service.waitMethodA();
        }
    }

    private static class Service {

        /**
         * lock
         */
        private ReentrantLock lock = new ReentrantLock();

        /**
         * condition
         */
        private Condition condition = lock.newCondition();

        public void waitMethodA() {
            lock.lock();
            try {
                logger.info("Begin...");
                Thread.sleep(5000);
                condition.wait();
                logger.info("End...");
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }
        }
    }
}
