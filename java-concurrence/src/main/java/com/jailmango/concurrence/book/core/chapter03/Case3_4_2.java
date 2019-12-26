package com.jailmango.concurrence.book.core.chapter03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case3_4_2 - 3.4.2 使用InheritableThreadLocal体现值继承特性
 *
 * @author he.gang33
 * @CreateDate 2019/12/20
 * @see com.jailmango.concurrence.book.core.chapter03
 * @since R9.0
 */
public class Case3_4_2 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case3_4_2.class);

    public static void main(String[] args) {
        try {
            for (int i = 0; i < 10; i++) {
                if (null == Data.inheritableThreadLocal.get()) {
                    Data.inheritableThreadLocal.set("这个值是main线程放入的");
                }
                logger.info("Main -> {}", Data.inheritableThreadLocal.get());
                Thread.sleep(100);
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
                    logger.info("Thread A -> {}", Data.inheritableThreadLocal.get());
                    Thread.sleep(100);
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class Data {

        /**
         * InheritableThreadLocal
         */
        public static InheritableThreadLocal inheritableThreadLocal = new InheritableThreadLocal();
    }
}
