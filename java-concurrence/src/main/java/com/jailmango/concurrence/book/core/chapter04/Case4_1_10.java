package com.jailmango.concurrence.book.core.chapter04;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case4_1_10
 *
 * @author he.gang33
 * @CreateDate 2020/6/1
 * @see com.jailmango.concurrence.book.core.chapter04
 * @since R9.0
 */
public class Case4_1_10 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case4_1_10.class);

    /**
     * main
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        // fair lock
        MyService fairService = new MyService(true);
        MyThread[] threads1 = new MyThread[5];
        MyThread[] threads2 = new MyThread[5];

        for (int i = 0; i < threads1.length; i++) {
            threads1[i] = new MyThread("arr1 - " + i, fairService);
        }

        for (int i = 0; i < threads1.length; i++) {
            threads1[i].start();
        }

        for (int i = 0; i < threads2.length; i++) {
            threads2[i] = new MyThread("arr2 - " + i, fairService);
        }

        for (int i = 0; i < threads1.length; i++) {
            threads2[i].start();
        }

        // unfair lock
        MyService unfairService = new MyService(false);
        MyThread[] threads3 = new MyThread[5];
        MyThread[] threads4 = new MyThread[5];

        for (int i = 0; i < threads3.length; i++) {
            threads3[i] = new MyThread("arr1 - " + i, unfairService);
        }

        for (int i = 0; i < threads3.length; i++) {
            threads3[i].start();
        }

        for (int i = 0; i < threads4.length; i++) {
            threads4[i] = new MyThread("arr2 - " + i, unfairService);
        }

        for (int i = 0; i < threads3.length; i++) {
            threads4[i].start();
        }
    }

    private static class MyService {

        /**
         * lock
         */
        private Lock lock;

        /**
         * Constructor
         * 
         * @param fair boolean
         */
        public MyService(boolean fair) {
            this.lock = new ReentrantLock(fair);
        }

        public void doService() {
            lock.lock();
            try {
                logger.info("{} doservice...", Thread.currentThread().getName());
                Thread.sleep(500);
                lock.unlock();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class MyThread extends Thread {

        /**
         * service
         */
        private MyService service;

        /**
         * Constructor
         * 
         * @param service MyService
         */
        public MyThread(MyService service) {
            super();
            this.service = service;
        }

        /**
         * Constructor
         * 
         * @param name String
         * @param service MyService
         */
        public MyThread(String name, MyService service) {
            super(name);
            this.service = service;
        }

        @Override
        public void run() {
            service.doService();
        }
    }
}
