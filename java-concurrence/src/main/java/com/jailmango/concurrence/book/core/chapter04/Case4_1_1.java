package com.jailmango.concurrence.book.core.chapter04;

import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case4_1_1 - 4.1.1 使用ReentrantLock实现同步
 *
 * @author jailmango
 * @CreateDate 2019/12/26
 * @see com.jailmango.concurrence.book.core.chapter04
 * @since R9.0
 */
public class Case4_1_1 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case4_1_1.class);

    public static void main(String[] args) {
        MyService service = new MyService();
        MyThread a = new MyThread(service);
        MyThread b = new MyThread(service);
        MyThread c = new MyThread(service);
        MyThread d = new MyThread(service);
        MyThread e = new MyThread(service);

        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }

    private static class MyThread extends Thread {

        /**
         * MyService
         */
        private MyService service;

        /**
         * Constructor
         * 
         * @param service MyService
         */
        public MyThread(MyService service) {
            this.service = service;
        }

        @Override
        public void run() {
            service.doService();
        }
    }

    private static class MyService {

        /**
         * ReentrantLock
         */
        private ReentrantLock lock = new ReentrantLock();

        public void doService() {
            lock.lock();

            try {
                for (int i = 0; i < 5; i++) {
                    logger.info("{} -> {}", Thread.currentThread().getName(), (i + 1));
                }
            }
            finally {
                lock.unlock();
            }

        }
    }
}
