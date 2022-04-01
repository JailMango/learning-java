package com.jailmango.concurrence.book.core.chapter01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case1_13 - 1.13 yield()
 *
 * @author jailmango
 * @CreateDate 2019-05-22
 * @see com.jailmango.concurrence.book.core.chapter01
 * @since R9.0
 */
public class Case1_13 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case1_13.class);

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
    }

    static class MyThread extends Thread {

        @Override
        public void run() {
            long begin = System.currentTimeMillis();
            long count = 0L;

            for (int i = 0; i < 5000000; i++) {
                // 将「Thread.yield();」注释掉，会明显减少运行时间。因为每次没有放弃CPU资源。
                Thread.yield();
                count += i + 1;
            }

            long end = System.currentTimeMillis();
            logger.info("Cost: [{}]", end - begin);
        }
    }

}
