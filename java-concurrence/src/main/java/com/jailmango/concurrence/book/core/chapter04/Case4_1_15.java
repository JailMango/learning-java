package com.jailmango.concurrence.book.core.chapter04;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case4_1_15 - 4.1.15. public final boolean hasQueuedThreads()方法的使用 <br/>
 * 查询是否有线程正在等待获取此锁，也就是等待队列中是否有等待的线程。
 * 
 * @author he.gang33
 * @CreateDate 2020/7/14
 * @see com.jailmango.concurrence.book.core.chapter04
 * @since R9.0
 */
public class Case4_1_15 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case4_1_15.class);

    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();
        Runnable runnable = service::waitMethod;

        // step-1
        Thread threadA = new Thread(runnable);
        threadA.start();
        Thread.sleep(500);
        Thread threadB = new Thread(runnable);
        threadB.start();
        Thread.sleep(500);

        logger.info("Thread-A hasQueueThread: [{}]", service.lock.hasQueuedThread(threadA));
        logger.info("Thread-B hasQueueThread: [{}]", service.lock.hasQueuedThread(threadB));
        logger.info("hasQueueThreads: [{}]", service.lock.hasQueuedThreads());
    }

    private static class MyService {

        /**
         * lock
         */
        private ReentrantLock lock = new ReentrantLock();

        /**
         * condition
         */
        private Condition condition = lock.newCondition();

        /**
         * wait
         */
        public void waitMethod() {
            lock.lock();
            try {
                Thread.sleep(Integer.MAX_VALUE);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }
        }
    }
}
