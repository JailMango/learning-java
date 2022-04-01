package com.jailmango.concurrence.book.core.chapter03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case3_3_5 - 3.3.5 验证重写initialValue()方法的隔离性
 *
 * @author jailmango
 * @CreateDate 2019/12/20
 * @see com.jailmango.concurrence.book.core.chapter03
 * @since R9.0
 */
public class Case3_3_5 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case3_3_5.class);

    public static void main(String[] args) {
        try {
            for (int i = 0; i < 10; i++) {
                logger.info("Main -> {}", Data.threadLocalExt.get());
                Thread.sleep(200);
            }
            Thread.sleep(5000);

            ThreadA a = new ThreadA();
            a.start();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class ThreadA extends Thread {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    logger.info("Thread A -> {}", Data.threadLocalExt.get());
                    Thread.sleep(200);
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class Data {
        /**
         * ThreadLocalExt
         */
        public static ThreadLocalExt threadLocalExt = new ThreadLocalExt();
    }

    private static class ThreadLocalExt extends ThreadLocal {
        @Override
        protected Object initialValue() {
            return System.currentTimeMillis();
        }
    }
}
