package com.jailmango.concurrence.book.core.chapter01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case1_11_6
 *
 * @author he.gang33
 * @CreateDate 2019-05-22
 * @see com.jailmango.concurrence.book.core.chapter01
 * @since R9.0
 */
public class Case1_11_6 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case1_11_6.class);

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            logger.info("MyThread running...");

            try {
                // 通常情况下不需要显式的捕获ThreadDeath异常
                this.stop();
            }
            catch (ThreadDeath e) {
                logger.error("Catch ThreadDeath...");
            }
        }
    }
}
