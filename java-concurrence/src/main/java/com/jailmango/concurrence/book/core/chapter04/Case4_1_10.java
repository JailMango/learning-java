package com.jailmango.concurrence.book.core.chapter04;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case4_1_10
 *
 * @author he.gang33
 * @CreateDate 2020/6/1
 * @see com.jailmango.concurrence.book.core.chapter04
 * @since R9.0
 */
public class Case4_1_10 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case4_1_10.class);

    private static class MyService {
        private Lock lock;

        public MyService(boolean fair) {
            this.lock = new ReentrantLock(fair);
        }

        public void doService() {
            lock.lock();
            try {
                logger.info("{} doservice...", Thread.currentThread().getName());
                Thread.sleep(500);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
