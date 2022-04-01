package com.jailmango.concurrence.book.core.chapter02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case2_1_1 0 - 2.1.1 方法内的变量是线程安全的
 *
 * @author jailmango
 * @CreateDate 2019-05-23
 * @see com.jailmango.concurrence.book.core.chapter02
 * @since R9.0
 */
public class Case2_1_1 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case2_1_1.class);

    public static void main(String[] args) throws InterruptedException {
        HasSelfPrivateNum num = new HasSelfPrivateNum();

        ThreadA a = new ThreadA(num);
        ThreadB b = new ThreadB(num);

        // 不存在线程不安全问题。虽然HasSelfPrivateNum是共享数据对象，但是实际打印的count是方法内的变量，是私有的，永远不存在线程安全的问题。
        a.start();
        Thread.sleep(100);
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
            num.setNum("Tread-B");
        }
    }

    static class HasSelfPrivateNum {

        /**
         * setNum
         * 
         * @param name String
         */
        public void setNum(String name) {
            try {
                int count = 0;

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
