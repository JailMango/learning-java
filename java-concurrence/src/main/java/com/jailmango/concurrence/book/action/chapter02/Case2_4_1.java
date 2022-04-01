package com.jailmango.concurrence.book.action.chapter02;

import lombok.extern.slf4j.Slf4j;

/**
 * 2.4 线程组
 *
 * @author jailmango
 * @CreateDate 2020/9/21
 * @see com.jailmango.concurrence.book.action.chapter02
 * @since R9.0
 */
@Slf4j
public class Case2_4_1 {

    public static final Object lock = new Object();

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        ThreadGroup tg = new ThreadGroup("Group");
        Thread thread1 = new Thread(tg, new SubThread(), "Thread-1");
        Thread thread2 = new Thread(tg, new SubThread(), "Thread-2");
        thread1.start();
        thread2.start();

        log.info("Thread Group active count: [{}]", tg.activeCount());

        tg.list();
    }

    private static class SubThread implements Runnable {

        @Override
        public void run() {
            String msg = Thread.currentThread().getThreadGroup().getName() + "-" + Thread.currentThread().getName();

            while (true) {
                log.info("{} start", msg);
                try {
                    Thread.sleep(3000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("{} end", msg);
            }
        }
    }
}
