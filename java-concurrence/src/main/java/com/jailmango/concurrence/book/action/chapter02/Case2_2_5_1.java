package com.jailmango.concurrence.book.action.chapter02;

import lombok.extern.slf4j.Slf4j;

/**
 * 2.2.5 挂起和继续执行 <br/>
 * 反例 <br/>
 * Thread-2无法被唤醒，且状态仍显示为Runnable，严重影响我们对于系统的判断
 *
 * @author he.gang33
 * @CreateDate 2020/9/17
 * @see com.jailmango.concurrence.book.action.chapter02
 * @since R9.0
 */
@Slf4j
public class Case2_2_5_1 {

    public static Object lock = new Object();

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        ChangeThread t1 = new ChangeThread("Thread-1", lock);
        ChangeThread t2 = new ChangeThread("Thread-2", lock);

        t1.start();
        Thread.sleep(1000);
        t2.start();

        Thread.sleep(1000);
        t1.resume();
        log.info("resume Thread-1...");
        t2.resume();
        log.info("resume Thread-2...");

        t1.join();
        t2.join();
    }

    private static class ChangeThread extends Thread {

        private Object lock;

        public ChangeThread(String name, Object lock) {
            super(name);
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock) {
                log.info("doing...");
                Thread.currentThread().suspend();
                log.info("end...");
            }
        }
    }

}
