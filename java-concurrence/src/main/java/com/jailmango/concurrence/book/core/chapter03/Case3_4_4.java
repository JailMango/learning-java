package com.jailmango.concurrence.book.core.chapter03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case3_4_4 - 3.4.4 父线程有最新的值，子线程仍是旧值
 * 结果表明，父线程数据更新，不影响子线程
 * @author he.gang33
 * @CreateDate 2019/12/25
 * @see com.jailmango.concurrence.book.core.chapter03
 * @since R9.0
 */
public class Case3_4_4 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case3_4_4.class);

    /**
     * main
     * 
     * @param args String[]
     * @throws InterruptedException InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        if (null == Data.inheritableThreadLocal.get()) {
            Data.inheritableThreadLocal.set("此值是main线程放入的值...old");
        }

        logger.info("Main -> {}", Data.inheritableThreadLocal.get());
        Thread.sleep(100);

        ThreadA a = new ThreadA();
        a.start();

        Thread.sleep(4000);
        Data.inheritableThreadLocal.set("此值是main线程放入的值...new");
        logger.info("Main -> {}", Data.inheritableThreadLocal.get());
    }

    private static class ThreadA extends Thread {

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    logger.info("Thread A -> {}", Data.inheritableThreadLocal.get());
                    Thread.sleep(1000);
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
