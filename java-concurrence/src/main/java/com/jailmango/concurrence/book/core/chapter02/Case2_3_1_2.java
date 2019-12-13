package com.jailmango.concurrence.book.core.chapter02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case2_3_1_2 - 2.3.1 - 2. 使用多线程解决死循环 解决2.3.1.1的问题
 *
 * @author he.gang33
 * @CreateDate 2019-05-29
 * @see com.jailmango.concurrence.book.core.chapter02
 * @since R9.0
 */
public class Case2_3_1_2 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case2_3_1_2.class);

    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        new Thread(service).start();

        Thread.sleep(3000);
        logger.info("Stop it...");
        // 利用多线程可以结束死循环
        service.setFinished(true);
    }

    static class Service implements Runnable {

        private boolean isFinished = false;

        @Override
        public void run() {
            doService();
        }

        public void doService() {
            try {
                while (!isFinished) {
                    logger.info("Thread[{}] do service begin...", Thread.currentThread().getName());
                    Thread.sleep(1000);
                    logger.info("Thread[{}] do service end...", Thread.currentThread().getName());
                }

                logger.info("Thread[{}] exit loop...", Thread.currentThread().getName());
            }
            catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }
        }

        public void setFinished(boolean finished) {
            isFinished = finished;
        }
    }
}
