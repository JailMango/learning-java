package com.jailmango.concurrence.book.core.chapter01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case1_11_2
 *
 * @author he.gang33
 * @CreateDate 2019-05-21
 * @see com.jailmango.concurrence.book.core.chapter01
 * @since R9.0
 */
public class Case1_11_2 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case1_11_2.class);

    public static void main(String[] args) throws InterruptedException {
        run();
        run2();
        run3();
    }

    /**
     * 输出false/false Thread.interrupted()会清除线程中断状态，即执行过后会将状态true置为false
     * 
     * @throws InterruptedException InterruptedException
     */
    public static void run() throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        Thread.sleep(10);
        myThread.interrupt();
        // 这里判断的对象是当前线程(即为main线程)
        logger.info("Thread: [{}], Interrupt: [{}]", Thread.currentThread().getName(), Thread.interrupted());
        logger.info("Thread: [{}], Interrupt: [{}]", Thread.currentThread().getName(), Thread.interrupted());
        logger.info("Thread[{}] end...", Thread.currentThread().getName());
    }

    /**
     * 输出true/false
     */
    public static void run2() {
        Thread.currentThread().interrupt();
        logger.info("Thread: [{}], Interrupt: [{}]", Thread.currentThread().getName(), Thread.interrupted());
        logger.info("Thread: [{}], Interrupt: [{}]", Thread.currentThread().getName(), Thread.interrupted());
        logger.info("Thread[{}] end...", Thread.currentThread().getName());
    }

    /**
     * 输出true/true this.isInterrupted(),不会清楚线程终端状态
     * 
     * @throws InterruptedException InterruptedException
     */
    public static void run3() throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        Thread.sleep(10);
        myThread.interrupt();
        // 这里判断的对象是当前线程(即为main线程)
        logger.info("Thread: [{}], Interrupt: [{}]", myThread.getName(), myThread.isInterrupted());
        logger.info("Thread: [{}], Interrupt: [{}]", myThread.getName(), myThread.isInterrupted());
        logger.info("Thread[{}] end...", Thread.currentThread().getName());
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 200; i++) {
                logger.info("Thread: [{}], Count: [{}]", Thread.currentThread().getName(), (i + 1));
            }
        }
    }
}
