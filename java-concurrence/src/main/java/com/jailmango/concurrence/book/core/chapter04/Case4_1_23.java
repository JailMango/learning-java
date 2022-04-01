package com.jailmango.concurrence.book.core.chapter04;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 4.1.23 public boolean await(long time, TimeUnit unit)方法的使用 <br/>
 * 该方法和public final native void wait(long timeout)方法一样，具有自动唤醒线程的功能 <br/>
 *
 * @author jailmango
 * @CreateDate 2020/8/12
 * @see com.jailmango.concurrence.book.core.chapter04
 * @since R9.0
 */
public class Case4_1_23 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case4_1_23.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        MyService service = new MyService();
        Runnable runnable = () -> service.doService();
        Thread th = new Thread(runnable);
        th.start();
    }

    private static class MyService {

        /**
         * lock
         */
        private Lock lock = new ReentrantLock();

        /**
         * condition
         */
        private Condition condition = lock.newCondition();

        public void doService() {
            lock.lock();
            try {
                logger.info("await begin...");
                condition.await(3, TimeUnit.SECONDS);
                logger.info("await end...");
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
