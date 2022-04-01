package com.jailmango.concurrence.book.core.chapter03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case3_4_5 - 3.4.5 子线程有最新的值，父线程仍是旧值
 *
 * @author jailmango
 * @CreateDate 2019/12/25
 * @see com.jailmango.concurrence.book.core.chapter03
 * @since R9.0
 */
public class Case3_4_5 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case3_4_5.class);

    public static void main(String[] args) throws InterruptedException {
        if (null == Data.inheritableThreadLocal.get()) {
            Data.inheritableThreadLocal.set("此值是main线程放入的...");
        }

        logger.info("Main -> {}", Data.inheritableThreadLocal.get());
        Thread.sleep(100);

        ThreadA a = new ThreadA();
        a.start();
        Thread.sleep(3000);

        for (int i = 0; i < 10; i++) {
            logger.info("Main -> {}", Data.inheritableThreadLocal.get());
            Thread.sleep(1000);
        }
    }

    private static class ThreadA extends Thread {

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    logger.info("Thread A -> {}", Data.inheritableThreadLocal.get());
                    Thread.sleep(1000);

                    if (5 == i) {
                        Data.inheritableThreadLocal.set("此值是ThreadA放入的...new");
                        logger.info("Thread A已经存在新的值...");
                    }
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
