package com.jailmango.concurrence.book.action.chapter03;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import lombok.extern.slf4j.Slf4j;

/**
 * Condition_3_1_2
 *
 * @author he.gang33
 * @CreateDate 2020/9/30
 * @see com.jailmango.concurrence.book.action.chapter03
 * @since R9.0
 */
@Slf4j
public class C3_1_2_重入锁好搭档Condition {

    public static ReentrantLock lock = new ReentrantLock();

    public static Condition condition = lock.newCondition();

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        MyRunnable myRunnable = new MyRunnable();
        Thread t1 = new Thread(myRunnable);
        t1.start();
        log.info("wait...");
        Thread.sleep(3000);
        lock.lock();
        condition.signal();
        lock.unlock();
        log.info("release lock...");
    }

    private static class MyRunnable implements Runnable {

        @Override
        public void run() {
            try {
                lock.lock();
                log.info("get lock...");
                log.info("wait...");
                condition.await();
                log.info("continue...");
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                lock.unlock();
                log.info("release lock...");
            }
        }
    }
}
