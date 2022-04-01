package com.jailmango.concurrence.book.core.chapter03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case3_2_3 - 3.2.3 join(long)方法的使用
 *
 * @author jailmango
 * @CreateDate 2019/12/18
 * @see com.jailmango.concurrence.book.core.chapter03
 * @since R9.0
 */
public class Case3_2_3 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case3_2_3.class);

    /**
     * main
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        logger.info("主线程main开始...");

        try {
            ThreadA tha = new ThreadA();
            tha.start();
            tha.join(2000);
        }
        catch (InterruptedException e) {
            logger.info("主线程main捕获InterruptedException异常...");
            e.printStackTrace();
        }

        logger.info("主线程main结束...");
    }

    private static class ThreadA extends Thread {

        @Override
        public void run() {
            logger.info("子线程A开始...");
            try {
                Thread.sleep(5000);
            }
            catch (InterruptedException e) {
                logger.info("主线程main捕获InterruptedException异常...");
                e.printStackTrace();
            }
            logger.info("子线程A结束...");
        }
    }
}
