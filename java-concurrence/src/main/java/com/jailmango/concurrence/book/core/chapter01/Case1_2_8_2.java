package com.jailmango.concurrence.book.core.chapter01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case1_2_8_2 - 1.2.8 共享数据
 *
 * @author jailmango
 * @CreateDate 2019-05-20
 * @see com.jailmango.concurrence.book.core.chapter01
 * @since R9.0
 */
public class Case1_2_8_2 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case1_2_8_2.class);

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread th1 = new Thread(myThread, "Thread-1");
        Thread th2 = new Thread(myThread, "Thread-2");
        Thread th3 = new Thread(myThread, "Thread-3");
        Thread th4 = new Thread(myThread, "Thread-4");
        Thread th5 = new Thread(myThread, "Thread-5");
        Thread th6 = new Thread(myThread, "Thread-6");

        th1.start();
        th2.start();
        th3.start();
        th4.start();
        th5.start();
        th6.start();
    }

    static class MyThread implements Runnable {

        private int count = 10;

        /**
         * 加上synchronized关键字，可以避免出现非线程安全问题。
         */
        @Override
        public synchronized void run() {
            if (count >= 0) {
                logger.info("Name: [{}], Count: [{}]", Thread.currentThread().getName(), count--);
            }
        }
    }
}
