package com.jailmango.concurrence.book.action.chapter02;

import lombok.extern.slf4j.Slf4j;

/**
 * 2.2.5 挂起和继续执行 <br/>
 * 解决前面的问题 <br/>
 *
 * @author jailmango
 * @CreateDate 2020/9/17
 * @see com.jailmango.concurrence.book.action.chapter02
 * @since R9.0
 */
@Slf4j
public class Case2_2_5_2 {

    public static Object lock = new Object();

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        ChangeThread ct = new ChangeThread("Change-1", lock);
        ReadThread rt = new ReadThread("Read-1", lock);

        ct.start();
        rt.start();

        Thread.sleep(2000);

        ct.suspendMe();
        log.info("suspend...");

        Thread.sleep(2000);

        ct.resumeMe();
        log.info("resume...");
    }

    private static class ChangeThread extends Thread {

        public volatile boolean suspendMe = false;

        private Object lock;

        public ChangeThread(String name, Object lock) {
            super(name);
            this.lock = lock;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (this) {
                    while (suspendMe) {
                        try {
                            log.info("waiting...");
                            wait();
                            log.info("waiting end...");
                        }
                        catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

                synchronized (lock) {
                    log.info("writing...");
                }

                Thread.yield();
            }
        }

        public void suspendMe() {
            this.suspendMe = true;
        }

        public void resumeMe() {
            this.suspendMe = false;
            synchronized (this) {
                notify();
            }
        }
    }

    private static class ReadThread extends Thread {

        private Object lock;

        public ReadThread(String name, Object lock) {
            super(name);
            this.lock = lock;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    log.info("reading...");
                }

                Thread.yield();
            }
        }
    }

}
