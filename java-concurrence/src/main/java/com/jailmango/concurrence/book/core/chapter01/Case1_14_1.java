package com.jailmango.concurrence.book.core.chapter01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case1_14_1 - 1.14.1 线程优先级的继承特性
 *
 * @author jailmango
 * @CreateDate 2019-05-22
 * @see com.jailmango.concurrence.book.core.chapter01
 * @since R9.0
 */
public class Case1_14_1 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case1_14_1.class);

    public static void main(String[] args) {
        MyThread1 thread = new MyThread1("Thread-1");
        thread.setPriority(5);

        // 线程优先级具有继承性，即线程A中启动线程B，若不另行指定线程B的优先级，则线程B的优先级与线程A保持一致。
        thread.start();
    }

    static class MyThread1 extends Thread {

        public MyThread1(String name) {
            super(name);
        }

        @Override
        public void run() {
            logger.info("Thread: [{}], Priority: [{}]", Thread.currentThread().getName(),
                Thread.currentThread().getPriority());

            MyThread2 thread = new MyThread2("Thread-2");
            // thread.setPriority(6);
            thread.start();
        }
    }

    static class MyThread2 extends Thread {

        public MyThread2(String name) {
            super(name);
        }

        @Override
        public void run() {
            logger.info("Thread: [{}], Priority: [{}]", Thread.currentThread().getName(),
                Thread.currentThread().getPriority());
        }
    }

}
