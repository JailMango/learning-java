package com.jailmango.concurrence.book.core.chapter04;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case4_1_3_1 - 4.1.3 await()方法的错误使用与更正
 * 该示例会出现异常(java.lang.IllegalMonitorStateException)
 * 因为调用condition.await()方法之前，必须先调用lock.lock()来获得锁
 * @author jailmango
 * @CreateDate 2019/12/27
 * @see com.jailmango.concurrence.book.core.chapter04
 * @since R9.0
 */
public class Case4_1_3_1 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case4_1_3_1.class);

    public static void main(String[] args) {
        Service service = new Service();
        ThreadA a = new ThreadA(service);
        a.start();
    }

    private static class ThreadA extends Thread {

        /**
         * Service
         */
        private Service service;

        /**
         * Constructor
         * 
         * @param service
         */
        public ThreadA(Service service) {
            this.service = service;
        }

        @Override
        public void run() {
            service.await();
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

        /**
         * await
         */
        public void await() {
            try {
                condition.await();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
