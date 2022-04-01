package com.jailmango.concurrence.book.core.chapter01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case1_11_8
 *
 * @author jailmango
 * @CreateDate 2019-05-22
 * @see com.jailmango.concurrence.book.core.chapter01
 * @since R9.0
 */
public class Case1_11_8 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case1_11_8.class);

    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread();
        thread.start();
        Thread.sleep(50);
        thread.interrupt();
    }

    static class MyThread extends Thread {

        @Override
        public void run() {
            while (true) {
                if (this.isInterrupted()) {
                    logger.info("interrupt...");

                    // 使用return也可以实现线程停止操作，但是不如抛出异常好。。尽量选择抛出异常。。
                    return;
                }

                logger.info("Time: [{}]", System.currentTimeMillis());
            }
        }
    }

}
