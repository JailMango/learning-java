package com.jailmango.concurrence.book.action.chapter03;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import lombok.extern.slf4j.Slf4j;

/**
 * 可重入锁_锁申请等待限时_3_1_2
 *
 * @author jailmango
 * @CreateDate 2020/9/30
 * @see com.jailmango.concurrence.book.action.chapter03
 * @since R9.0
 */
@Slf4j
public class C3_1_1_2_可重入锁_锁申请等待限时 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        TimeLock runnable = new TimeLock();
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t1.start();
        t2.start();
    }

    private static class TimeLock implements Runnable {

        private ReentrantLock lock = new ReentrantLock();

        @Override
        public void run() {
            try {
                if (lock.tryLock(5, TimeUnit.SECONDS)) {
                    log.info("get lock. doing...");
                    Thread.sleep(10000);
                }
                else {
                    log.info("get lock failed...");
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                if (lock.isHeldByCurrentThread()) {
                    lock.unlock();
                    log.info("释放锁，线程退出...");
                }
            }
        }
    }
}
