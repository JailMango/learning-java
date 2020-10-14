package com.jailmango.concurrence.book.core.chapter04;

import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 4.1.19 public boolean isLocked()的使用<br/>
 * 查询此锁是否由任意线程保持，并没有释放
 *
 * @author he.gang33
 * @CreateDate 2020/8/3
 * @see com.jailmango.concurrence.book.core.chapter04
 * @since R9.0
 */
public class Case4_1_19 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case4_1_19.class);

    /**
     * main
     * @param args String[
     */
    public static void main(String[] args) {
        final MyService service = new MyService();
        Runnable runnable = () -> service.doService();
        Thread thread = new Thread(runnable);
        thread.start();
    }

    private static class MyService {

        /**
         * lock
         */
        private ReentrantLock lock = new ReentrantLock();

        /**
         * doService
         */
        public void doService() {
            logger.info("Lock isLocked: [{}]", lock.isLocked());
            lock.lock();
            try {
                logger.info("Lock isLocked: [{}]", lock.isLocked());
            }
            finally {
                lock.unlock();
            }
            logger.info("Lock isLocked: [{}]", lock.isLocked());
        }
    }
}
