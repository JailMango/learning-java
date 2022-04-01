package com.jailmango.concurrence.book.core.chapter02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case2_2_1 - 2.2.1 synchronized方法弊端
 *
 * @author jailmango
 * @CreateDate 2019-05-24
 * @see com.jailmango.concurrence.book.core.chapter02
 * @since R9.0
 */
public class Case2_2_1 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case2_2_1.class);

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

        // 虽然使用了两个线程，但是实际处理方法doTask()为同步方法，导致还是非并行执行，整体上较为耗时
        // 可以使用synchronized代码块缩小同步范围，缓解这个问题
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
        public synchronized void doTask() {
            try {
                logger.info("do task begin...");
                Thread.sleep(3000);

                data1 = "get data1. Thread[" + Thread.currentThread().getName() + "], Time["
                    + System.currentTimeMillis() + "]";
                data2 = "get data2. Thread[" + Thread.currentThread().getName() + "], Time["
                    + System.currentTimeMillis() + "]";

                logger.info(data1);
                logger.info(data2);
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
