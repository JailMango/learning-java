package com.jailmango.concurrence.book.core.chapter01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case1_12_1 - 1.12.1 suspend() resume()
 *
 * @author jailmango
 * @CreateDate 2019-05-22
 * @see com.jailmango.concurrence.book.core.chapter01
 * @since R9.0
 */
public class Case1_12_1 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case1_12_1.class);

    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread();
        thread.start();
        Thread.sleep(50);

        // 可以看出suspend()暂停后，线程确实没在执行
        thread.suspend();
        logger.info("Time: [{}], Count: [{}]", System.currentTimeMillis(), thread.getCount());
        Thread.sleep(2000);
        logger.info("Time: [{}], Count: [{}]", System.currentTimeMillis(), thread.getCount());

        // 线程可以恢复
        thread.resume();
        Thread.sleep(50);

        // 可以看出suspend()暂停后，线程确实没在执行
        thread.suspend();
        logger.info("Time: [{}], Count: [{}]", System.currentTimeMillis(), thread.getCount());
        Thread.sleep(2000);
        logger.info("Time: [{}], Count: [{}]", System.currentTimeMillis(), thread.getCount());
    }

    static class MyThread extends Thread {

        /**
         * count
         */
        private Long count = 0L;

        @Override
        public void run() {
            while (true) {
                this.count++;
            }
        }

        public Long getCount() {
            return count;
        }

        public void setCount(Long count) {
            this.count = count;
        }
    }
}
