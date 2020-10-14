package com.jailmango.concurrence.book.action.chapter03;

import java.util.concurrent.locks.ReentrantLock;

import lombok.extern.slf4j.Slf4j;

/**
 * 3.1.1.1 可重入锁 - 中断响应
 *
 * @author he.gang33
 * @CreateDate 2020/9/28
 * @see com.jailmango.concurrence.book.action.chapter03
 * @since R9.0
 */
@Slf4j
public class 可重入锁_模拟死锁_3_1_1_1 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        MyRunnable runnable1 = new MyRunnable(1);
        MyRunnable runnable2 = new MyRunnable(2);

        Thread t1 = new Thread(runnable1);
        Thread t2 = new Thread(runnable2);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        log.info("end...");
    }

    private static class MyRunnable implements Runnable {

        private static ReentrantLock lock1 = new ReentrantLock();

        private static ReentrantLock lock2 = new ReentrantLock();

        private int index;

        public MyRunnable(int index) {
            this.index = index;
        }

        @Override
        public void run() {
            try {
                if (index == 1) {
                    log.info("lock1...");
                    lock1.lockInterruptibly();

                    try {
                        Thread.sleep(2000);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    lock2.lockInterruptibly();
                }
                else {
                    log.info("lock2...");
                    lock2.lockInterruptibly();

                    try {
                        Thread.sleep(2000);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    lock1.lockInterruptibly();
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                if (lock1.isHeldByCurrentThread()) {
                    lock1.unlock();
                }

                if (lock2.isHeldByCurrentThread()) {
                    lock2.unlock();
                }
            }
        }
    }
}
