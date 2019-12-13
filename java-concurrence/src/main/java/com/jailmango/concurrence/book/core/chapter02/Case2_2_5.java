package com.jailmango.concurrence.book.core.chapter02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case2_2_5 - 2.2.5 synchronized{}代码块间的同步性
 *
 * @author he.gang33
 * @CreateDate 2019-05-24
 * @see com.jailmango.concurrence.book.core.chapter02
 * @since R9.0
 */
public class Case2_2_5 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case2_2_5.class);

    public static void main(String[] args) {
        Task task = new Task();

        MyThreadA a = new MyThreadA("Thread-A", task);
        MyThreadB b = new MyThreadB("Thread-B", task);

        // 可以doTaskA()和doTaskB()两者是顺序执行，并没有并行执行
        // 因为两个方法内都持有了锁，使用的对象监视器为同一个，锁对象为同一个即为同一把锁，因此只有其中一个执行完毕释放锁，之后，另一个才能执行。
        // 说明synchronized(this){} 不同同步代码块之间是存在同步性的
        a.start();
        b.start();
    }

    static class MyThreadA extends Thread {

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
        public MyThreadA(String name, Task task) {
            super(name);
            this.task = task;
        }

        @Override
        public void run() {
            task.doTaskA();
        }
    }

    static class MyThreadB extends Thread {

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
        public MyThreadB(String name, Task task) {
            super(name);
            this.task = task;
        }

        @Override
        public void run() {
            task.doTaskB();
        }
    }

    static class Task {

        public void doTaskA() {
            try {
                synchronized (this) {
                    logger.info("Thread[{}] do Task-A begin... Time[{}]", Thread.currentThread().getName(),
                        System.currentTimeMillis());
                    Thread.sleep(2000);
                    logger.info("Thread[{}] do Task-A end... Time[{}]", Thread.currentThread().getName(),
                        System.currentTimeMillis());
                }
            }
            catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }
        }

        public void doTaskB() {
            synchronized (this) {
                logger.info("Thread[{}] do Task-B begin... Time[{}]", Thread.currentThread().getName(),
                    System.currentTimeMillis());
                logger.info("Thread[{}] do Task-B end... Time[{}]", Thread.currentThread().getName(),
                    System.currentTimeMillis());
            }
        }
    }
}
