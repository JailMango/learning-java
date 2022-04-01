package com.jailmango.concurrence.book.action.chapter03;

import java.util.concurrent.locks.ReentrantLock;

import lombok.extern.slf4j.Slf4j;

/**
 * 3.1.1 可重入锁
 *
 * @author jailmango
 * @CreateDate 2020/9/28
 * @see com.jailmango.concurrence.book.action.chapter03
 * @since R9.0
 */
@Slf4j
public class C3_1_1_可重入锁 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        MyRunnable runnable = new MyRunnable(new ReentrantLock(), 0);
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        log.info("Count[{}]", runnable.count);
    }

    private static class MyRunnable implements Runnable {

        private ReentrantLock lock;

        private int count;

        public MyRunnable(ReentrantLock lock, int count) {
            this.lock = lock;
            this.count = count;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                lock.lock();
                lock.lock();
                try {
                    count++;
                }
                finally {
                    lock.unlock();
                    lock.unlock();
                }
            }
        }
    }
}
