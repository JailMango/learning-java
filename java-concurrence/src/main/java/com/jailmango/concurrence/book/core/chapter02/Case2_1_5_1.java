package com.jailmango.concurrence.book.core.chapter02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case2_1_5_1 - 2.1.5 synchronized方法与对象锁
 *
 * @author he.gang33
 * @CreateDate 2019-05-23
 * @see com.jailmango.concurrence.book.core.chapter02
 * @since R9.0
 */
public class Case2_1_5_1 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case2_1_5_1.class);

    public static void main(String[] args) {
        method1();
    }

    /**
     * method1
     */
    private static void method1() {
        MyObject shareObj = new MyObject();
        ThreadA a = new ThreadA(shareObj);
        ThreadB b = new ThreadB(shareObj);
        // 线程A持有MyObject对象的锁，但是线程B完全可以「异步调用非synchronized方法」
        a.start();
        b.start();
    }

    static class ThreadA extends Thread {

        /**
         * MyObject
         */
        private MyObject obj;

        /**
         * Constructor
         * 
         * @param obj MyObject
         */
        public ThreadA(MyObject obj) {
            this.obj = obj;
        }

        @Override
        public void run() {
            obj.synchronizedMethod();
        }
    }

    static class ThreadB extends Thread {

        /**
         * MyObject
         */
        private MyObject obj;

        /**
         * Constructor
         *
         * @param obj MyObject
         */
        public ThreadB(MyObject obj) {
            this.obj = obj;
        }

        @Override
        public void run() {
            obj.method();
        }
    }

    static class MyObject {

        public synchronized void synchronizedMethod() {
            try {
                logger.info("Thread[{}] synchronized method begin...", Thread.currentThread().getName());
                Thread.sleep(200);
                logger.info("Thread[{}] synchronized method end...", Thread.currentThread().getName());
            }
            catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }
        }

        public void method() {
            try {
                logger.info("Thread[{}] normal method begin...", Thread.currentThread().getName());
                Thread.sleep(200);
                logger.info("Thread[{}] normal method end...", Thread.currentThread().getName());
            }
            catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }
        }
    }
}
