package com.jailmango.concurrence.book.core.chapter01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case1_4_isAliveOther
 *
 * @author jailmango
 * @CreateDate 2019-05-21
 * @see com.jailmango.concurrence.book.core.chapter01
 * @since R9.0
 */
public class Case1_4_isAliveOther {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case1_4_isAliveOther.class);

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }

    static class MyThread extends Thread {

        public MyThread() {
            logger.info("MyThread constructor begin...");
            logger.info("Current Thread: [{}], Is Alive: [{}]", Thread.currentThread().getName(),
                Thread.currentThread().isAlive());
            logger.info("MyThread: [{}], Is Alive: [{}]", this.getName(), this.isAlive());
            logger.info("MyThread constructor end...");
        }

        @Override
        public void run() {
            logger.info("MyThread run begin...");
            logger.info("Current Thread: [{}], Is Alive: [{}]", Thread.currentThread().getName(),
                Thread.currentThread().isAlive());
            logger.info("MyThread: [{}], Is Alive: [{}]", this.getName(), this.isAlive());
            logger.info("MyThread run end...");
        }
    }
}
