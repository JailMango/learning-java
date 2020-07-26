package com.jailmango.concurrence.book.core.chapter04;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case4_1_13 - 4.1.13 public int getWaitQueueLength()的使用 <br/>
 * 该方法是返回等待与此锁相关的给定条件Condition的线程计数。例如：<br/>
 * 5个线程，每个线程都执行了同一个Condition.await(), <br/>
 * 则调用getWaitQueueLength(Condition condition), 返回的int值是5
 * 
 * @author he.gang33
 * @CreateDate 2020/7/7
 * @see com.jailmango.concurrence.book.core.chapter04
 * @since R9.0
 */
public class Case4_1_13 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case4_1_13.class);

    /**
     * main
     * 
     * @param args String[]
     * @throws InterruptedException InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        final MyService service = new MyService();
        Runnable runnable = () -> service.waitMethod();

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
                condition.await();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }
        }

        public void notifyMethod() {
            lock.lock();
            try {
                logger.info("有{}个线程正在等待Condition...", lock.getWaitQueueLength(condition));
            }
            finally {
                lock.unlock();
            }

        }
    }
}
