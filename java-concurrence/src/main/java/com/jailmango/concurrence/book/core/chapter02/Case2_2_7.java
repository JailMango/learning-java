package com.jailmango.concurrence.book.core.chapter02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case2_2_7
 *
 * @author he.gang33
 * @CreateDate 2019-05-24
 * @see com.jailmango.concurrence.book.core.chapter02
 * @since R9.0
 */
public class Case2_2_7 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case2_2_7.class);

    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();
        MyThread1 a = new MyThread1("Thread-A", task);
        MyThread2 b = new MyThread2("Thread-B", task);
        a.start();
        Thread.sleep(100);
        b.start();

        // 线程A与线程B实际运行效果是同步的。原因如下。
        // synchronized(this){}同步代码块，将当前类的对象作为锁。synchronized同步方法将所在类的对象作为锁。是同一把锁。
        // 线程A与线程B并行运行时，两者会竞争同一把锁，其中一个会被阻塞，最终呈现出同步的效果。

    }

    static class MyThread1 extends Thread {

        private Task task;

        public MyThread1(String name, Task task) {
            super(name);
            this.task = task;
        }

        @Override
        public void run() {
            task.doLongTimeTask();
        }
    }

    static class MyThread2 extends Thread {

        private Task task;

        public MyThread2(String name, Task task) {
            super(name);
            this.task = task;
        }

        @Override
        public void run() {
            task.doOtherTask();
        }
    }

    static class Task {

        public synchronized void doOtherTask() {
            logger.info("Thread[{}] do other task...", Thread.currentThread().getName());
        }

        public void doLongTimeTask() {
            synchronized (this) {
                for (int i = 0; i < 10; i++) {
                    logger.info("Thread[{}] do long time task synchronized... Count[{}]",
                        Thread.currentThread().getName(), (i + 1));
                    try {
                        Thread.sleep(500);
                    }
                    catch (InterruptedException e) {
                        logger.error(e.getLocalizedMessage());
                    }
                }
            }
        }
    }
}
