package com.jailmango.concurrence.book.core.chapter01;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case1_14_2
 *
 * @author jailmango
 * @CreateDate 2019-05-22
 * @see com.jailmango.concurrence.book.core.chapter01
 * @since R9.0
 */
public class Case1_14_2 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case1_14_2.class);

    public static void main(String[] args) {
        // for (int i = 0; i < 5; i++) {
        // MyThread thread1 = new MyThread();
        // thread1.setPriority(10);
        // thread1.start();
        // AnotherMyThread thread2 = new AnotherMyThread();
        // thread2.setPriority(1);
        // thread2.start();
        // }

        MyThread thread1 = new MyThread();
        thread1.setPriority(10);
        MyThread thread2 = new MyThread();
        thread2.setPriority(10);
        MyThread thread3 = new MyThread();
        thread3.setPriority(10);
        MyThread thread4 = new MyThread();
        thread4.setPriority(10);
        MyThread thread5 = new MyThread();
        thread5.setPriority(10);

        AnotherMyThread aThread1 = new AnotherMyThread();
        aThread1.setPriority(1);
        AnotherMyThread aThread2 = new AnotherMyThread();
        aThread2.setPriority(1);
        AnotherMyThread aThread3 = new AnotherMyThread();
        aThread3.setPriority(1);
        AnotherMyThread aThread4 = new AnotherMyThread();
        aThread4.setPriority(1);
        AnotherMyThread aThread5 = new AnotherMyThread();
        aThread5.setPriority(1);

        thread1.start();
        aThread1.start();
        thread2.start();
        aThread2.start();
        thread3.start();
        aThread3.start();
        thread4.start();
        aThread4.start();
        thread5.start();
        aThread5.start();
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            long begin = System.currentTimeMillis();
            long result = 0L;

            for (int m = 0; m < 10; m++) {
                for (int n = 0; n < 50000; n++) {
                    new Random().nextInt();
                    result += n;
                }
            }

            long end = System.currentTimeMillis();

            logger.info("★★★★★★★★★★★Thread-1★★★★★★★★★★★    Cost: [{}]", end - begin);
        }
    }

    static class AnotherMyThread extends Thread {
        @Override
        public void run() {
            long begin = System.currentTimeMillis();
            long result = 0L;

            for (int m = 0; m < 10; m++) {
                for (int n = 0; n < 50000; n++) {
                    new Random().nextInt();
                    result += n;
                }
            }

            long end = System.currentTimeMillis();

            logger.info("☆☆☆☆☆☆☆☆☆☆☆☆Thread-2☆☆☆☆☆☆☆☆☆☆☆☆    Cost: [{}]", end - begin);
        }
    }

}
