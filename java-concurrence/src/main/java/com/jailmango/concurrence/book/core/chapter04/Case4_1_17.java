package com.jailmango.concurrence.book.core.chapter04;

import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 4.1.17. public final boolean isFair()方法的使用 <br/>
 * 作用是判断是不是公平锁 <br/>
 *
 * @author he.gang33
 * @CreateDate 2020/8/3
 * @see com.jailmango.concurrence.book.core.chapter04
 * @since R9.0
 */
public class Case4_1_17 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case4_1_17.class);

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(true);
        logger.info("Lock is fair: [{}]", lock.isFair());

        ReentrantLock lock1 = new ReentrantLock(false);
        logger.info("Lock is fair: [{}]", lock1.isFair());

        ReentrantLock lock2 = new ReentrantLock();
        logger.info("Lock is fair: [{}]", lock2.isFair());
    }
}
