package com.jailmango.concurrence.book.core.chapter01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case1_2_4 - 1.2.4 执行start()顺序不代表run()的执行顺序
 *
 * @author he.gang33
 * @CreateDate 2019-05-17
 * @see com.jailmango.concurrence.book.core.chapter01
 * @since R9.0
 */
public class Case1_2_4 {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyThread("thread-1"));
        Thread thread2 = new Thread(new MyThread("thread-2"));
        Thread thread3 = new Thread(new MyThread("thread-3"));
        Thread thread4 = new Thread(new MyThread("thread-4"));
        Thread thread5 = new Thread(new MyThread("thread-5"));
        Thread thread6 = new Thread(new MyThread("thread-6"));
        Thread thread7 = new Thread(new MyThread("thread-7"));
        Thread thread8 = new Thread(new MyThread("thread-8"));
        Thread thread9 = new Thread(new MyThread("thread-9"));
        Thread thread10 = new Thread(new MyThread("thread-10"));
        Thread thread11 = new Thread(new MyThread("thread-11"));
        Thread thread12 = new Thread(new MyThread("thread-12"));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();
        thread10.start();
        thread11.start();
        thread12.start();
    }

    static class MyThread implements Runnable {

        /**
         * logger
         */
        private static final Logger logger = LoggerFactory.getLogger(MyThread.class);

        /**
         * name
         */
        private String name;

        public MyThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            logger.info("{} running...", name);
        }
    }
}
