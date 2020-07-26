package com.jailmango.concurrence.book.core.chapter04;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case4_1_15 - public final boolean hasQueuedThreads()方法的使用 <br/>
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

        // step-2
        Thread.sleep(500);
        logger.info("hasQueueThreads: [{}]", service.lock.hasQueuedThreads());

        logger.info("Thread-A hasQueueThread: [{}]", service.lock.hasQueuedThread(threadA));
    }

    private static class MyService {

        private ReentrantLock lock = new ReentrantLock();

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
