package com.jailmango.concurrence.book.core.chapter03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case3_2_1_1 - 3.2.1 不使用join()方法出现的问题
 *
 * @author he.gang33
 * @CreateDate 2019-07-25
 * @see com.jailmango.concurrence.book.core.chapter03
 * @since R9.0
 */
public class Case3_2_1_1 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case3_2_1_1.class);

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();

        logger.info("主线程[{}]想实现当子线程执行完毕后，再继续执行下去", Thread.currentThread().getName());
        logger.info("主线程[{}]不知道sleep()多久", Thread.currentThread().getName());
    }

    private static class MyThread extends Thread {
        @Override
        public void run() {
            int second = 2000;
            logger.info("子线程[{}] Second: [{}]", Thread.currentThread().getName(), second);
            try {
                Thread.sleep(second);
            }
            catch (InterruptedException e) {
                logger.error(e.getMessage());
            }
            logger.info("子线程[{}] end...", Thread.currentThread().getName());
        }
    }
}
