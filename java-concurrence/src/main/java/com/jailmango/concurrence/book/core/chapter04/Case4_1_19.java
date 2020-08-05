package com.jailmango.concurrence.book.core.chapter04;

import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case4_1_19
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

    public static void main(String[] args) {

    }

    private static class MyService {

        private ReentrantLock lock = new ReentrantLock();

        public void doService() {
            logger.info("Lock isLocked: [{{]", lock.isLocked());
        }
    }
}
