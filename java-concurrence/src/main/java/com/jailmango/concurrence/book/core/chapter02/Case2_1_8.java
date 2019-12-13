package com.jailmango.concurrence.book.core.chapter02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case2_1_8 - 2.1.8 锁重入支持继承
 *
 * @author he.gang33
 * @CreateDate 2019-05-23
 * @see com.jailmango.concurrence.book.core.chapter02
 * @since R9.0
 */
public class Case2_1_8 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case2_1_8.class);

    public static void main(String[] args) {

    }

    /**
     * 2.1.8 - 锁重入支持继承
     */
    private static void method1() {
        MyThread thread = new MyThread();
        // 程序可以正常倒数
        // Sub线程中的synchronized方法中，调用了父类的synchronized方法。说明锁重入支持继承。否则该例子跑不通。
        // 当存在父子类继承关系时，子类是完全可以通过锁重入调用父类的同步方法的。
        thread.start();
    }

    /**
     * 2.1.10 - 重写父类方法使用synchronized与不使用synchronized
     */
    private static void method2() {
        Sub sub = new Sub();
        MyThreadAnother a = new MyThreadAnother(sub);
        a.setName("Thread-A");
        MyThreadAnother b = new MyThreadAnother(sub);
        b.setName("Thread-B");
        // 重写的方法，若加synchronized，则为同步方法，反之为非同步方法
        a.start();
        b.start();
    }

    /**
     * 2.1.8
     */
    static class MyThread extends Thread {
        @Override
        public void run() {
            Sub sub = new Sub();
            sub.subMethod();
        }
    }

    /**
     * 2.1.10
     */
    static class MyThreadAnother extends Thread {

        /**
         * Sub
         */
        private Sub sub;

        /**
         * Constructor
         * 
         * @param sub Sub
         */
        public MyThreadAnother(Sub sub) {
            this.sub = sub;
        }

        @Override
        public void run() {
            sub.extendsMethod();
        }
    }

    static class Main {

        /**
         * count
         */
        public int count = 10;

        public synchronized void mainMethod() {
            try {
                logger.info("Thread[{}] main method - {}", Thread.currentThread().getName(), --count);
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }
        }

        public synchronized void extendsMethod() {
            try {
                logger.info("Thread[{}] main extends method begin - {}", Thread.currentThread().getName(),
                    System.currentTimeMillis());
                Thread.sleep(1000);
                logger.info("Thread[{}] main extends method end - {}", Thread.currentThread().getName(),
                    System.currentTimeMillis());
            }
            catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }
        }
    }

    static class Sub extends Main {

        public synchronized void subMethod() {
            try {
                while (count > 0) {
                    logger.info("Thread[{}] sub method - {}", Thread.currentThread().getName(), --count);
                    Thread.sleep(1000);
                    super.mainMethod();
                }
            }
            catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }
        }

        @Override
        public void extendsMethod() {
            try {
                logger.info("Thread[{}] sub extends method begin - {}", Thread.currentThread().getName(),
                    System.currentTimeMillis());
                Thread.sleep(1000);
                logger.info("Thread[{}] sub extends method end - {}", Thread.currentThread().getName(),
                    System.currentTimeMillis());
                super.extendsMethod();
            }
            catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }
        }
    }
}
