package com.jailmango.concurrence.book.core.chapter04;

import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case4_1_12 - 4.1.12 public final int getQueueLength()方法的使用 <br/>
 * 该方法的作用是返回正在等待获取此锁的线程估计数 <br/>
 * 若共有5个线程，其中1个线程长时间占有锁，那么调用getQueueLength()方法后，返回值为4 <br/>
 * 说明有4个线程同时在等待锁的释放
 * 
 * @author jailmango
 * @CreateDate 2020/7/6
 * @see com.jailmango.concurrence.book.core.chapter04
 * @since R9.0
 */
public class Case4_1_12 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case4_1_12.class);

    /**
     * main
     * 
     * @param args String[]
     * @throws InterruptedException InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();

        Runnable runnable = () -> service.doService();

        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(runnable);
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        Thread.sleep(2000);
        logger.info("{} threads waiting for lock...", service.lock.getQueueLength());
    }

    private static class MyService {

        /**
         * lock
         */
        private ReentrantLock lock = new ReentrantLock();

        /**
         * doService
         */
        public void doService() {
            lock.lock();
            logger.info("{} do service...", Thread.currentThread().getName());
            try {
                Thread.sleep(100000);
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
