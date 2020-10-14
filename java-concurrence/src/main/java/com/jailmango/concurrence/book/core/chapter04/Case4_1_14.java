package com.jailmango.concurrence.book.core.chapter04;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case4_1_14 - 4.1.14. public final boolean hasQueueThread(Thread thread)方法的使用 <br/>
 * 查询指定的线程是否正在等待获取此锁，也就是判断参数中的线程是否在等待队列中
 *
 * @author he.gang33
 * @CreateDate 2020/7/13
 * @see com.jailmango.concurrence.book.core.chapter04
 * @since R9.0
 */
public class Case4_1_14 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case4_1_14.class);

    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();
        Runnable runnable = service::waitMethod;

        Thread threadA = new Thread(runnable);
        threadA.start();
        Thread threadB = new Thread(runnable);
        threadB.start();

        Thread.sleep(500);
        logger.info("Thread-A hasQueueThread: [{}]", service.lock.hasQueuedThread(threadA));
        logger.info("Thread-B hasQueueThread: [{}]", service.lock.hasQueuedThread(threadB));
    }

    private static class MyService {

        /**
         * lock
         */
        private final ReentrantLock lock = new ReentrantLock();

        /**
         * condtion
         */
        private Condition condition = lock.newCondition();

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
