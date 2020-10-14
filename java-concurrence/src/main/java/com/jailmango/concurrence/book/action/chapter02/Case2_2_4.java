package com.jailmango.concurrence.book.action.chapter02;

import lombok.extern.slf4j.Slf4j;

/**
 * Case2_2_4
 *
 * @author he.gang33
 * @CreateDate 2020/9/17
 * @see com.jailmango.concurrence.book.action.chapter02
 * @since R9.0
 */
@Slf4j
public class Case2_2_4 {

    private static final Object lock = new Object();

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable1 = () -> {
            synchronized (lock) {
                log.info("runnable-1 start...");

                try {
                    log.info("runnable-1 wait...");
                    lock.wait();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }

                log.info("runnable-1 be notified...");
                try {
                    Thread.sleep(2000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("runnable-1 end...");
            }
        };

        Runnable runnable2 = () -> {
            synchronized (lock) {
                log.info("runnable-2 start...");

                log.info("runnable-2 notify...");
                lock.notifyAll();

                try {
                    Thread.sleep(2000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }

                log.info("runnable-2 end...");
            }
        };

        Thread thread1 = new Thread(runnable1);
        thread1.start();
        Thread.sleep(10);

        Thread thread2 = new Thread(runnable2);
        thread2.start();
    }
}
