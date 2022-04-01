package com.jailmango.concurrence.book.action.chapter03;

import java.util.concurrent.locks.LockSupport;

import lombok.extern.slf4j.Slf4j;

/**
 * 线程阻塞工具类LockSupport_3_1_7
 *
 * @author jailmango
 * @CreateDate 2020/10/8
 * @see com.jailmango.concurrence.book.action.chapter03
 * @since R9.0
 */
@Slf4j
public class C3_1_7_线程阻塞工具类LockSupport_中断响应 {

    private static Object objectLock = new Object();

    private static ChangeThread t1 = new ChangeThread("t1");

    private static ChangeThread t2 = new ChangeThread("t2");

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(1000);
        t2.start();
        Thread.sleep(1000);
        t1.interrupt();
        LockSupport.unpark(t2);

        t1.join();
        t2.join();
        log.info("end...");
    }

    private static class ChangeThread extends Thread {

        public ChangeThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (objectLock) {
                log.info("doing...");
                LockSupport.park();
                if (Thread.interrupted()) {
                    log.info("interrupted...");
                }

                log.info("end...");
            }
        }
    }

}
