package com.jailmango.concurrence.book.core.chapter01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case1_2_10 - 1.2.10
 *
 * @author he.gang33
 * @CreateDate 2019-05-21
 * @see com.jailmango.concurrence.book.core.chapter01
 * @since R9.0
 */
public class Case1_2_10 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case1_2_10.class);

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread th1 = new Thread(myThread, "Thread-1");
        Thread th2 = new Thread(myThread, "Thread-2");
        Thread th3 = new Thread(myThread, "Thread-3");
        Thread th4 = new Thread(myThread, "Thread-4");
        Thread th5 = new Thread(myThread, "Thread-5");
        Thread th6 = new Thread(myThread, "Thread-6");
        Thread th7 = new Thread(myThread, "Thread-7");
        Thread th8 = new Thread(myThread, "Thread-8");
        Thread th9 = new Thread(myThread, "Thread-9");
        Thread th10 = new Thread(myThread, "Thread-10");

        th1.start();
        th2.start();
        th3.start();
        th4.start();
        th5.start();
        th6.start();
        th7.start();
        th8.start();
        th9.start();
        th10.start();
    }

    static class MyThread implements Runnable {

        private int count = 10;

        @Override
        public void run() {
            count--;
            // 模拟线程不安全情况
            if (Thread.currentThread().getName().equals("Thread-1")) {
                try {
                    Thread.sleep(1);
                }
                catch (InterruptedException e) {
                    logger.info(e.getLocalizedMessage());
                }
            }

            // 虽然System.out.println()是同步的，但是count的操作是在该方法之前，无法避免线程不安全的问题
            System.out.println("Thread: [" + Thread.currentThread().getName() + "], Count: [" + count + "]");
            logger.info("Thread: [{}], Count: [{}]", Thread.currentThread().getName(), count);
        }
    }
}
