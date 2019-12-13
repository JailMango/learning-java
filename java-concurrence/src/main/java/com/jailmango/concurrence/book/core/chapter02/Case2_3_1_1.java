package com.jailmango.concurrence.book.core.chapter02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case2_3_1_1 - 2.3.1 - 1. volatile可见性，本例展示未使用volatile的情况 单线程出现死循环
 *
 * @author he.gang33
 * @CreateDate 2019-05-29
 * @see com.jailmango.concurrence.book.core.chapter02
 * @since R9.0
 */
public class Case2_3_1_1 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case2_3_1_1.class);

    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        service.doService();
        Thread.sleep(5000);
        service.setFinished(true);

        // 本例在doService()中出现死循环，原因是因为main线程一直在处理doService()方法，导致后续代码未能执行
    }

    static class Service {

        private boolean isFinished = false;

        public void doService() {
            try {
                while (!isFinished) {
                    logger.info("Thread[{}] do service begin...", Thread.currentThread().getName());
                    Thread.sleep(1000);
                    logger.info("Thread[{}] do service end...", Thread.currentThread().getName());
                }
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
