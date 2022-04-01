package com.jailmango.netty.lightman.netty.chat.counter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * CounterMain
 *
 * @author jailmango
 * @CreateDate 2019-08-16
 * @see com.jailmango.netty.lightman.netty.chat.counter
 * @since R9.0
 */
public class CounterMain {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(CounterMain.class);

    /**
     * count
     */
    private int count = 0;

    /**
     * main
     * 
     * @param args String[]
     * @throws InterruptedException InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread("Thread-1");
        t1.start();
        Thread.sleep(1000);

        MyThread t2 = new MyThread("Thread-2");
        t2.start();
        Thread.sleep(1000);

        MyThread t3 = new MyThread("Thread-3");
        t3.start();
        Thread.sleep(1000);

        MyThread t4 = new MyThread("Thread-4");
        t4.start();
        Thread.sleep(1000);

        MyThread t5 = new MyThread("Thread-5");
        t5.start();
        Thread.sleep(1000);

        logger.info("end...");
    }

    static class MyThread extends Thread {

        /**
         * Constructor
         * 
         * @param name String
         */
        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (true) {
                logger.info("{} -> {}", Thread.currentThread().getName(), ClientCounter.INSTANCE.connect());
            }
        }
    }

}
