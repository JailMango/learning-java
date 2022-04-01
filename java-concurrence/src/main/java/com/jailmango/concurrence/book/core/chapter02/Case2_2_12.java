package com.jailmango.concurrence.book.core.chapter02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case2_2_12 - 2.2.12
 *
 * @author jailmango
 * @CreateDate 2019-05-24
 * @see com.jailmango.concurrence.book.core.chapter02
 * @since R9.0
 */
public class Case2_2_12 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case2_2_12.class);

    public static void main(String[] args) throws InterruptedException {
        conclusion3();
    }

    /**
     * 结论1 - 当多个线程同时执行synchronized(x){}同步代码块时是同步的。前提是x是同一对象，即多个线程用同意把锁。
     * 本例中，由于MyObject为单例对象，且MyObject对象即为锁(对象监视器)，因此可以达到同步的效果。
     */
    private static void conclusion1() {
        MyObject obj = new MyObject();
        MyThread1 a = new MyThread1("Thread-A", obj);
        MyThread1 b = new MyThread1("Thread-B", obj);
        a.start();
        b.start();
    }

    /**
     * 结论2 - 当其他线程执行x对象中的synchronized方法时，呈现同步效果。因为是同一把锁。
     * 
     * @throws InterruptedException InterruptedException
     */
    private static void conclusion2() throws InterruptedException {
        MyObject obj = new MyObject();
        MyThread1 a = new MyThread1("Thread-A", obj);
        MyThread2 b = new MyThread2("Thread-B", obj);

        a.start();
        Thread.sleep(100);
        b.start();
    }

    /**
     * 结论3 - 当其他线程执行x对象中的synchronized(this){}代码块，呈现同步效果。
     * 
     * @throws InterruptedException InterruptedException
     */
    private static void conclusion3() throws InterruptedException {
        MyObject obj = new MyObject();
        MyThread1 a = new MyThread1("Thread-A", obj);
        MyThread3 b = new MyThread3("Thread-B", obj);

        a.start();
        Thread.sleep(100);
        b.start();
    }

    static class MyThread1 extends Thread {

        /**
         * MyObject
         */
        private MyObject obj;

        /**
         * Constructor
         * 
         * @param name String
         * @param obj MyObject
         */
        public MyThread1(String name, MyObject obj) {
            super(name);
            this.obj = obj;
        }

        @Override
        public void run() {
            new Service().normalService(obj);
        }
    }

    static class MyThread2 extends Thread {

        /**
         * MyObject
         */
        private MyObject obj;

        /**
         * Constructor
         *
         * @param name String
         * @param obj MyObject
         */
        public MyThread2(String name, MyObject obj) {
            super(name);
            this.obj = obj;
        }

        @Override
        public void run() {
            obj.synchronizedMethod();
        }
    }

    static class MyThread3 extends Thread {

        /**
         * MyObject
         */
        private MyObject obj;

        /**
         * Constructor
         *
         * @param name String
         * @param obj MyObject
         */
        public MyThread3(String name, MyObject obj) {
            super(name);
            this.obj = obj;
        }

        @Override
        public void run() {
            obj.synchronizedBlockMethod();
        }
    }

    static class Service {

        /**
         * normalService
         * 
         * @param obj MyObject
         */
        public void normalService(MyObject obj) {
            try {
                synchronized (obj) {
                    logger.info("Thread[{}] do normal service begin... Time[{}]", Thread.currentThread().getName(),
                        System.currentTimeMillis());
                    Thread.sleep(4000);
                    logger.info("Thread[{}] do normal service end... Time[{}]", Thread.currentThread().getName(),
                        System.currentTimeMillis());
                }
            }
            catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }
        }
    }

    static class MyObject {

        /**
         * synchronizedMethod
         */
        public synchronized void synchronizedMethod() {
            try {
                logger.info("Thread[{}] my object do synchronized method begin... Time[{}]",
                    Thread.currentThread().getName(), System.currentTimeMillis());
                Thread.sleep(2000);
                logger.info("Thread[{}] my object do synchronized method end... Time[{}]",
                    Thread.currentThread().getName(), System.currentTimeMillis());
            }
            catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }
        }

        /**
         * synchronizedBlockMethod
         */
        public void synchronizedBlockMethod() {
            logger.info("Thread[{}] my object do synchronized block method begin... Time[{}]",
                Thread.currentThread().getName(), System.currentTimeMillis());

            synchronized (this) {
                logger.info("Thread[{}] my object do synchronized block... Time[{}]", Thread.currentThread().getName(),
                    System.currentTimeMillis());
            }

            logger.info("Thread[{}] my object do synchronized block method begin... Time[{}]",
                Thread.currentThread().getName(), System.currentTimeMillis());
        }

    }

}
