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
public class Case2_1_5_2 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case2_1_5_2.class);

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
        // 1. synchronized修饰方法，并不是锁方法，而是所当前类的对象
        // 2. 由于线程A调用了synchronized方法，先持有了MyObject对象的锁，因此线程B再「调用synchronized方法」时，若线程A未释放该锁，则需要等待
        // 3. java中，只有「将对象作为锁」的这种说法，没有「锁方法」方法这种说法
        // 4. java中，锁就是对象，对象可以映射成锁。哪个线程拿到这把锁，哪个线程就可以执行这个对象的synchronized方法
        // 5. 在X对象中使用了synchronized修饰非静态方法，则X对象就成了锁
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

        public synchronized void method() {
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
