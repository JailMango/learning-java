package com.jailmango.concurrence.book.core.chapter04;

import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case4_1_11 - 4.1.11 public int getHoldCount()方法的使用<br/>
 * 查询"当前线程"保持次锁定的个数，即调用lock()方法的次数 <br/>
 * lock.lock() -> count + 1 <br/>
 * lock.unlock() -> count - 1 <br/>
 *
 * @author he.gang33
 * @CreateDate 2020/7/6
 * @see com.jailmango.concurrence.book.core.chapter04
 * @since R9.0
 */
public class Case4_1_11 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case4_1_11.class);

    /**
     * main
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        MyService service = new MyService();
        service.doService1();
    }

    private static class MyService {

        /**
         * lock
         */
        private ReentrantLock lock = new ReentrantLock(true);

        public void doService1() {
            logger.info("step-a -> [{}]", lock.getHoldCount());
            lock.lock();
            logger.info("step-b -> [{}]", lock.getHoldCount());
            doService2();
            logger.info("step-f -> [{}]", lock.getHoldCount());
            lock.unlock();
            logger.info("step-g -> [{}]", lock.getHoldCount());
        }

        public void doService2() {
            logger.info("step-c -> [{}]", lock.getHoldCount());
            lock.lock();
            logger.info("step-d -> [{}]", lock.getHoldCount());
            lock.unlock();
            logger.info("step-e -> [{}]", lock.getHoldCount());
        }
    }

}
