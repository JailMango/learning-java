package com.jailmango.concurrence.book.core.chapter02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case2_2_8 - 2.2.8 将任意对象作为锁
 *
 * @author jailmango
 * @CreateDate 2019-05-24
 * @see com.jailmango.concurrence.book.core.chapter02
 * @since R9.0
 */
public class Case2_2_8 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case2_2_8.class);

    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();
        MyThread1 a = new MyThread1("Thread-A", task);
        MyThread2 b = new MyThread2("Thread-B", task);
        // 这里使用synchronized{}同步代码块，保证了线程安全。数据未被篡改。
        // 这里使用了锁非this对象
        /*
         * 优点：如果一个类中有多个synchronized方法，虽然能保证同步，但是影响效率，因为synchronized方法的锁对象是当前类的对象。 如果使用了同步代码块锁非this对象(即
         * synchronized(非this){} )，则代码块中的程序与其他synchronized方法是异步的，因为是两把不同的锁。 不与其他锁this对象的方法争夺this锁，提高了效率。
         */
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
         * Lock
         */
        private String lock = new String();

        /**
         * doTask
         * 
         * @param username String
         * @param password String
         */
        private void doTask(String username, String password) {
            try {
                synchronized (lock) {
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
