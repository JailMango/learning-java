package com.jailmango.concurrence.book.core.chapter02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case2_2_3 - 2.2.3 用同步代码块解决同步方法的弊端
 *
 * @author he.gang33
 * @CreateDate 2019-05-24
 * @see com.jailmango.concurrence.book.core.chapter02
 * @since R9.0
 */
public class Case2_2_3 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case2_2_3.class);

    public static void main(String[] args) {
        Task task = new Task();

        MyThread1 thread1 = new MyThread1(task);
        MyThread2 thread2 = new MyThread2(task);
        thread1.start();
        thread2.start();

        try {
            Thread.sleep(10000);
        }
        catch (InterruptedException e) {
            logger.error(e.getLocalizedMessage());
        }

        long begin = CommonUtils.begin1;

        if (CommonUtils.begin2 < begin) {
            begin = CommonUtils.begin2;
        }

        long end = CommonUtils.end1;

        if (CommonUtils.end2 > end) {
            end = CommonUtils.end2;
        }

        // 与之前不同，较为耗时的获取数据部分为异步。之后数据处理为同步，因为涉及到共享对象的实例变量。缩小的synchronized同步代码块的范围，提高了效率。
        // 当一个线程访问object的synchronized(this){}同步代码块时，另一个线程仍然可以访问该object对象中的非synchronized(this){}同步代码块。
        logger.info("main end... Cost[{}]", (end - begin) / 1000);
    }

    static class Task {

        /**
         * data1
         */
        private String data1;

        /**
         * data2
         */
        private String data2;

        /**
         * doTask - 模拟任务
         */
        public void doTask() {
            try {
                logger.info("do task begin...");
                Thread.sleep(3000);

                // 获取数据
                String privateData1 = "get data1. Thread[" + Thread.currentThread().getName() + "], Time["
                    + System.currentTimeMillis() + "]";
                String privateData2 = "get data2. Thread[" + Thread.currentThread().getName() + "], Time["
                    + System.currentTimeMillis() + "]";

                synchronized (this) {
                    data1 = privateData1;
                    data2 = privateData2;
                    // 实际处理数据
                    logger.info(data1);
                    logger.info(data2);
                }

                logger.info("do task end...");
            }
            catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }

        }
    }

    static class MyThread1 extends Thread {

        /**
         * Task
         */
        private Task task;

        /**
         * Constructor
         *
         * @param task Task
         */
        public MyThread1(Task task) {
            this.task = task;
        }

        @Override
        public void run() {
            CommonUtils.begin1 = System.currentTimeMillis();
            task.doTask();
            CommonUtils.end1 = System.currentTimeMillis();
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
         * @param task Task
         */
        public MyThread2(Task task) {
            this.task = task;
        }

        @Override
        public void run() {
            CommonUtils.begin2 = System.currentTimeMillis();
            task.doTask();
            CommonUtils.end2 = System.currentTimeMillis();
        }
    }

    static class CommonUtils {

        /**
         * begin1
         */
        public static long begin1;

        /**
         * end1
         */
        public static long end1;

        /**
         * begin2
         */
        public static long begin2;

        /**
         * end2
         */
        public static long end2;
    }
}
