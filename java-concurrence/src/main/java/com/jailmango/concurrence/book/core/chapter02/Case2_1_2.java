package com.jailmango.concurrence.book.core.chapter02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case2_1_2 - 2.1.2 实例变量的线程安全问题
 *
 * @author he.gang33
 * @CreateDate 2019-05-23
 * @see com.jailmango.concurrence.book.core.chapter02
 * @since R9.0
 */
public class Case2_1_2 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case2_1_2.class);

    public static void main(String[] args) throws InterruptedException {
        HasSelfPrivateNum num = new HasSelfPrivateNum();

        ThreadA a = new ThreadA(num);
        ThreadB b = new ThreadB(num);

        // 此处会发生线程不安全的问题，即线程B的值会覆盖掉线程A的值。
        // 由于两个线程访问同一个对象中没有同步的方法且方法中操作了实例变量，因此有可能发生线程不安全的问题。
        a.start();
        Thread.sleep(1000);
        b.start();
    }

    static class ThreadA extends Thread {

        /**
         * HasSelfPrivateNum
         */
        private HasSelfPrivateNum num;

        /**
         * Constructor
         * 
         * @param num HasSelfPrivateNum
         */
        public ThreadA(HasSelfPrivateNum num) {
            this.num = num;
        }

        @Override
        public void run() {
            num.setNum("Thread-A");
        }
    }

    static class ThreadB extends Thread {

        /**
         * HasSelfPrivateNum
         */
        private HasSelfPrivateNum num;

        /**
         * Constructor
         * 
         * @param num HasSelfPrivateNum
         */
        public ThreadB(HasSelfPrivateNum num) {
            this.num = num;
        }

        @Override
        public void run() {
            num.setNum("Thread-B");
        }
    }

    static class HasSelfPrivateNum {

        /**
         * count
         */
        private int count = 0;

        /**
         * setNum - 该方法可使用synchronized变为同步方法，避免线程不安全的问题
         * 
         * @param name String
         */
        private void setNum(String name) {
            try {
                if ("Thread-A".equals(name)) {
                    count = 100;
                    logger.info("Thread-A set number...");
                    Thread.sleep(2000);
                }
                else {
                    count = 200;
                    logger.info("Thread-B set number...");
                }

                logger.info("get number: [{}]", count);
            }
            catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }
        }
    }
}
