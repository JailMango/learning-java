package com.jailmango.concurrence.book.core.chapter01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case1_2_8_1 - 1.2.8 不共享数据
 *
 * @author he.gang33
 * @CreateDate 2019-05-20
 * @see com.jailmango.concurrence.book.core.chapter01
 * @since R9.0
 */
public class Case1_2_8_1 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case1_2_8_1.class);

    public static void main(String[] args) {
        Thread th1 = new Thread(new MyThread(), "Thread-1");
        Thread th2 = new Thread(new MyThread(), "Thread-2");
        Thread th3 = new Thread(new MyThread(), "Thread-3");
        Thread th4 = new Thread(new MyThread(), "Thread-4");
        Thread th5 = new Thread(new MyThread(), "Thread-5");

        th1.start();
        th2.start();
        th3.start();
        th4.start();
        th5.start();
    }

    static class MyThread implements Runnable {

        private int count = 5;

        @Override
        public void run() {
            while (count >= 0) {
                logger.info("Name: [{}], Count: [{}]", Thread.currentThread().getName(), count--);
            }
        }
    }
}
