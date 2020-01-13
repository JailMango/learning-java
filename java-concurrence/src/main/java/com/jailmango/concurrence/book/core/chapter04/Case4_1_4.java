package com.jailmango.concurrence.book.core.chapter04;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case4_1_4
 *
 * @author he.gang33
 * @CreateDate 2020/1/10
 * @see com.jailmango.concurrence.book.core.chapter04
 * @since R9.0
 */
public class Case4_1_4 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case4_1_4.class);

    private static class Service {

        /**
         * ReentrantLock
         */
        private ReentrantLock lock = new ReentrantLock();

        /**
         * Condition
         */
        private Condition condition = lock.newCondition();

        public void await() {
            lock.lock();
            try {
                logger.info("await...");
                condition.await();
            }
            catch (InterruptedException e) {
                logger.error("catch InterruptedException...");
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }
        }
    }
}
