package com.jailmango.concurrence.book.core.chapter02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case2_2_$
 *
 * @author jailmango
 * @CreateDate 2019-05-24
 * @see com.jailmango.concurrence.book.core.chapter02
 * @since R9.0
 */
public class Case2_2_4 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case2_2_4.class);

    public static void main(String[] args) {
        Task task = new Task();

        MyThread a = new MyThread("Thread-A", task);
        MyThread b = new MyThread("Thread-B", task);

        // 异步执行是线程A和线程B交替进行
        // synchronized{}同步代码块，是一个线程持有锁，执行完后，释放锁，另一个线程再执行
        // 可以看出synchronized{}同步代码块确实是同步执行
        a.start();
        b.start();
    }

    static class MyThread extends Thread {

        /**
         * Task
         */
        private Task task;

        /**
         * Constructor
         * 
         * @param name String
         * @param task Task
         */
        public MyThread(String name, Task task) {
            super(name);
            this.task = task;
        }

        @Override
        public void run() {
            task.doTask();
        }
    }

    static class Task {

        public void doTask() {
            for (int i = 0; i < 10; i++) {
                logger.info("Thread[{}] not synchronized block. Count[{}]", Thread.currentThread().getName(), i);
            }

            logger.info("★★★★★★★★★★★★★★★★★★★★★★★★★★★");

            synchronized (this) {
                for (int i = 0; i < 10; i++) {
                    logger.info("Thread[{}] synchronized block. Count[{}]", Thread.currentThread().getName(), i);
                }
            }
        }
    }
}
