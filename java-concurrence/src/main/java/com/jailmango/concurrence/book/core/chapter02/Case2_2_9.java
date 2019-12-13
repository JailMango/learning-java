package com.jailmango.concurrence.book.core.chapter02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case2_2_9 - 2.2.9 多个锁就是异步执行
 *
 * @author he.gang33
 * @CreateDate 2019-05-24
 * @see com.jailmango.concurrence.book.core.chapter02
 * @since R9.0
 */
public class Case2_2_9 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case2_2_9.class);

    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();
        MyThread1 a = new MyThread1("Thread-A", task);
        MyThread2 b = new MyThread2("Thread-B", task);
        // 数据被篡改，出现线程不安全问题
        // 原因是这里的synchronized(new String()){}，每次执行锁对象不同，是不同的锁，无法起到同步的作用。
        a.start();
        Thread.sleep(100);
        b.start();
    }

    static class MyThread1 extends Thread {

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
        public MyThread1(String name, Task task) {
            super(name);
            this.task = task;
        }

        @Override
        public void run() {
            task.doTask("a", "aa");
        }
    }

    static class MyThread2 extends Thread {

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
        public MyThread2(String name, Task task) {
            super(name);
            this.task = task;
        }

        @Override
        public void run() {
            task.doTask("b", "bb");
        }
    }

    static class Task {

        /**
         * username
         */
        private String username;

        /**
         * password
         */
        private String password;

        /**
         * doTask
         *
         * @param username String
         * @param password String
         */
        private void doTask(String username, String password) {
            try {
                synchronized (new String()) {
                    logger.info("Thread[{}] entry synchronized block...", Thread.currentThread().getName());
                    this.username = username;
                    Thread.sleep(3000);
                    this.password = password;
                    logger.info("Thread[{}] - Username:[{}], Password:[{}]", Thread.currentThread().getName(),
                        this.username, this.password);
                    logger.info("Thread[{}] exit synchronized block...", Thread.currentThread().getName());
                }
            }
            catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }
        }
    }
}
