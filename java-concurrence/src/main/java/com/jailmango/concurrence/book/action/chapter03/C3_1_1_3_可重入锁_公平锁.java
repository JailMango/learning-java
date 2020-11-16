package com.jailmango.concurrence.book.action.chapter03;

import java.util.concurrent.locks.ReentrantLock;

import lombok.extern.slf4j.Slf4j;

/**
 * 3.1.3 公平锁
 *
 * @author he.gang33
 * @CreateDate 2020/9/30
 * @see com.jailmango.concurrence.book.action.chapter03
 * @since R9.0
 */
@Slf4j
public class C3_1_1_3_可重入锁_公平锁 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        // 公平锁，交替执行
        // 非公平锁，一个线程会倾向于再次获取已经持有的锁，这种分配方式是高效的
        MyRunnable runnable = new MyRunnable();
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t1.start();
        t2.start();
    }

    private static class MyRunnable implements Runnable {

        private ReentrantLock fairLock = new ReentrantLock(true);

        @Override
        public void run() {
            while (true) {
                try {
                    fairLock.lock();
                    Thread.sleep(1500);
                    log.info("{}获得锁", Thread.currentThread().getName());
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    fairLock.unlock();
                }
            }
        }
    }
}
