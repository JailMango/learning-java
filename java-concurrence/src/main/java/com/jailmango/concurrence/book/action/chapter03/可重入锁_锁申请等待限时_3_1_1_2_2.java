package com.jailmango.concurrence.book.action.chapter03;

import java.util.concurrent.locks.ReentrantLock;

import lombok.extern.slf4j.Slf4j;

/**
 * 可重入锁_锁申请等待限时_3_1_2
 *
 * @author he.gang33
 * @CreateDate 2020/9/30
 * @see com.jailmango.concurrence.book.action.chapter03
 * @since R9.0
 */
@Slf4j
public class 可重入锁_锁申请等待限时_3_1_1_2_2 {

    private static ReentrantLock lock1 = new ReentrantLock();

    private static ReentrantLock lock2 = new ReentrantLock();

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        TryLock tryLock1 = new TryLock(1);
        TryLock tryLock2 = new TryLock(2);

        Thread t1 = new Thread(tryLock1);
        Thread t2 = new Thread(tryLock2);
        t1.start();
        t2.start();
    }

    private static class TryLock implements Runnable {

        private int index;

        public TryLock(int index) {
            this.index = index;
        }

        @Override
        public void run() {
            if (index == 1) {
                while (true) {
                    if (lock1.tryLock()) {
                        try {
                            try {
                                Thread.sleep(500);
                            }
                            catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            if (lock2.tryLock()) {
                                try {
                                    log.info("done...");
                                    return;
                                }
                                finally {
                                    lock2.unlock();
                                }
                            }
                        }
                        finally {
                            lock1.unlock();
                        }
                    }
                }
            }
            else if (index == 2) {
                while (true) {
                    if (lock2.tryLock()) {
                        try {
                            try {
                                Thread.sleep(500);
                            }
                            catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            if (lock1.tryLock()) {
                                try {
                                    log.info("done...");
                                }
                                finally {
                                    lock1.unlock();
                                }
                            }
                        }
                        finally {
                            lock2.unlock();
                        }
                    }
                }
            }
        }
    }
}
