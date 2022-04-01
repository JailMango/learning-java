package com.jailmango.concurrence.book.core.chapter01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case1_14_4 - 1.14.4
 *
 * @author jailmango
 * @CreateDate 2019-05-22
 * @see com.jailmango.concurrence.book.core.chapter01
 * @since R9.0
 */
public class Case1_14_4 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case1_14_4.class);

    public static void main(String[] args) throws InterruptedException {
        MyThread threadA = new MyThread();
        threadA.setPriority(10);
        MyThread threadB = new MyThread();
        threadA.setPriority(1);

        threadA.start();
        threadB.start();

        Thread.sleep(20000);
        threadB.stop();
        threadA.stop();

        // 在长时间的情况下，优先级高的占用的时间多一些，但不是绝对的。
        logger.info("Thread-A Count:[{}]", threadA.getCount());
        logger.info("Thread-B Count:[{}]", threadB.getCount());
    }

    static class MyThread extends Thread {

        /**
         * count
         */
        private long count = 0L;

        @Override
        public void run() {
            while (true) {
                count++;
            }
        }

        public long getCount() {
            return count;
        }
    }
}
