package com.jailmango.concurrence.book.core.chapter02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case2_2_19 - 2.2.19 多线程死锁
 *
 * @author jailmango
 * @CreateDate 2019-05-29
 * @see com.jailmango.concurrence.book.core.chapter02
 * @since R9.0
 */
public class Case2_2_19 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case2_2_19.class);

    public static void main(String[] args) throws InterruptedException {
        MyThread runnable = new MyThread();

        runnable.setName("Thread-A");
        Thread a = new Thread(runnable);
        a.start();

        Thread.sleep(100);

        runnable.setName("Thread-B");
        Thread b = new Thread(runnable);
        b.start();

        // jps指令，可以列出java进程
        // jstack -l {pid}指令
        // 本例存在死锁，上述指令会出现 Found 1 deadlock.的提示，并且会指出哪两个线程出现死锁
    }

    static class MyThread implements Runnable {

        private String name;

        private Object lock1 = new Object();

        private Object lock2 = new Object();

        @Override
        public void run() {
            if ("Thread-A".equals(this.name)) {
                synchronized (lock1) {
                    try {
                        logger.info("Thread[{}] - Username[{}]", Thread.currentThread().getName(), this.name);
                        Thread.sleep(2000);
                    }
                    catch (InterruptedException e) {
                        logger.error(e.getLocalizedMessage());
                    }

                    synchronized (lock2) {
                        logger.info("Thread[{}] lock1 -> lock2...", Thread.currentThread().getName());
                    }
                }
            }

            if ("Thread-B".equals(this.name)) {
                synchronized (lock2) {
                    try {
                        logger.info("Thread[{}] - Username[{}]", Thread.currentThread().getName(), this.name);
                        Thread.sleep(2000);
                    }
                    catch (InterruptedException e) {
                        logger.error(e.getLocalizedMessage());
                    }

                    synchronized (lock1) {
                        logger.info("Thread[{}] lock2 -> lock1...", Thread.currentThread().getName());
                    }
                }
            }
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
