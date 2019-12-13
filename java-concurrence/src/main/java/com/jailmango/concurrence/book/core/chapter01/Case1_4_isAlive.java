package com.jailmango.concurrence.book.core.chapter01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case1_4_isAlive - 1.3之后的方法实例
 *
 * @author he.gang33
 * @CreateDate 2019-05-21
 * @see com.jailmango.concurrence.book.core.chapter01
 * @since R9.0
 */
public class Case1_4_isAlive {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case1_4_isAlive.class);

    public static void method1() {
        MyThread myThread = new MyThread();
        logger.info("Before start. Is Alive: [{}]", myThread.isAlive());
        myThread.start();
        logger.info("After start. Is Alive: [{}]", myThread.isAlive());
    }

    public static void method2() {
        MyThread myThread = new MyThread();
        logger.info("Before start. Is Alive: [{}]", myThread.isAlive());
        myThread.start();
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            logger.error(e.getLocalizedMessage());
        }

        // 与method1()有区别，此处输出[false]。因为main线程挂起时，MyThread线程已经执行完成。而method1()，此处MyThread线程尚未执行完成。
        logger.info("After start. Is Alive: [{}]", myThread.isAlive());
    }

    static class MyThread extends Thread {

        public MyThread() {
            logger.info("MyThread Constructor begin...");
            logger.info("Current Thread: [{}]", Thread.currentThread().getName());
            logger.info("Thread Name: [{}]", this.getName());
            logger.info("MyThread Constructor end...");
        }

        @Override
        public void run() {
            logger.info("MyThread run begin...");
            logger.info("Current Thread: [{}]", Thread.currentThread().getName());
            logger.info("Thread Name: [{}]", this.getName());
            logger.info("Is Alive: [{}]", this.isAlive());
            logger.info("MyThread run end...");
        }
    }
}
