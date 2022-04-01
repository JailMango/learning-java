package com.jailmango.concurrence.book.core.chapter02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case2_1_4 - 2.1.4 多个对象多个锁
 *
 * @author jailmango
 * @CreateDate 2019-05-23
 * @see com.jailmango.concurrence.book.core.chapter02
 * @since R9.0
 */
public class Case2_1_4 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case2_1_4.class);

    public static void main(String[] args) {
        HasSelfPrivateNum num1 = new HasSelfPrivateNum();
        HasSelfPrivateNum num2 = new HasSelfPrivateNum();

        // 由于此处新建了两个对象，因此会有两把锁，且线程A和线程B分别持有不同的内容，不是竞争关系，因此不存在线程不安全的问题。
        ThreadA a = new ThreadA(num1);
        ThreadB b = new ThreadB(num2);
        a.start();
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
