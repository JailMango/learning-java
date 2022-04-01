package com.jailmango.concurrence.book.core.chapter04;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 4.1.16. public boolean hasWaiters(Condition condition)方法的使用 <br/>
 * 查询是否有线程正在等待与此锁有关的condition条件，也就是是否执行了condition.await()而呈等待状态 <br/>
 * 
 * @author jailmango
 * @CreateDate 2020/7/28
 * @see com.jailmango.concurrence.book.core.chapter04
 * @since R9.0
 */
public class Case4_1_16 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case4_1_16.class);

    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();
        Runnable runnable = service::waitMethod;

        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(runnable);
        }

        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }

        Thread.sleep(2000);
        service.notifyMethod();
    }

    private static class MyService {

        /**
         * ReentrantLock
         */
        private ReentrantLock lock = new ReentrantLock();

        /**
         * Condition
         */
        private Condition condition = lock.newCondition();

        /**
         * waitMethod
         */
        public void waitMethod() {
            lock.lock();

            try {
                condition.await();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }
        }

        /**
         * notifyMethod
         */
        public void notifyMethod() {
            lock.lock();
            try {
                logger.info("有没有线程正在等待condition: [{}]", lock.hasWaiters(condition));
                logger.info("线程数: [{}]", lock.getWaitQueueLength(condition));
            }
            finally {
                lock.unlock();
            }
        }
    }
}
