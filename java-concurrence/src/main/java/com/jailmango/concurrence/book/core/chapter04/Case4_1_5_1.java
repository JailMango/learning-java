package com.jailmango.concurrence.book.core.chapter04;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case4_1_5_1 - 4.1.5 await()方法暂停线程运行的原理
 *
 * @author he.gang33
 * @CreateDate 2020/1/13
 * @see com.jailmango.concurrence.book.core.chapter04
 * @since R9.0
 */
public class Case4_1_5_1 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case4_1_5_1.class);

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock(true);
        lock.lock();
        try {
            Condition condition = lock.newCondition();
            logger.info("await begin...");
            condition.await();
            logger.info("await end...");
        }
        finally {
            lock.unlock();
        }

    }
}
