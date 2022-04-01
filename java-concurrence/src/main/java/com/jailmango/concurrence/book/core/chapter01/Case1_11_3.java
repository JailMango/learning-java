package com.jailmango.concurrence.book.core.chapter01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case1_11_3 - 1.11.3 图1-44
 *
 * @author jailmango
 * @CreateDate 2019-05-21
 * @see com.jailmango.concurrence.book.core.chapter01
 * @since R9.0
 */
public class Case1_11_3 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case1_11_3.class);

    public static void main(String[] args) throws InterruptedException {
        runMyThread();
        runMyInterruptThread();
    }

    public static void runMyThread() throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        Thread.sleep(10);
        myThread.interrupt();
    }

    public static void runMyInterruptThread() throws InterruptedException {
        MyInterruptThread thread = new MyInterruptThread();
        thread.start();
        Thread.sleep(10);
        thread.interrupt();
    }

    static class MyThread extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 200; i++) {
                if (this.isInterrupted()) {
                    logger.info("Thread[{}] interrupt. Exit...", Thread.currentThread().getName());
                    break;
                }
                logger.info("Thread: [{}], Count: [{}]", Thread.currentThread().getName(), (i + 1));
            }

            // 虽然线程被interrupt, 但是该句话仍会被执行
            logger.info("Thread[{}] out loop...", Thread.currentThread().getName());
        }
    }

    static class MyInterruptThread extends Thread {

        @Override
        public void run() {
            try {
                for (int i = 0; i < 200; i++) {
                    if (this.isInterrupted()) {
                        logger.info("Thread[{}] interrupt. Exit...", Thread.currentThread().getName());
                        // 使用异常可以避免执行for之后的语句，达到中断的效果
                        throw new InterruptedException();
                    }
                    logger.info("Thread: [{}], Count: [{}]", Thread.currentThread().getName(), (i + 1));
                }

                // 虽然线程被interrupt, 但是该句话仍会被执行
                logger.info("Thread[{}] out loop...", Thread.currentThread().getName());
            }
            catch (InterruptedException e) {
                logger.info("MyInterruptThread catch InterruptedException...");
            }

        }
    }

}
