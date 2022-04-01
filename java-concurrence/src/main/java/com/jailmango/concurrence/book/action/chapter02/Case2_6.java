package com.jailmango.concurrence.book.action.chapter02;

import lombok.extern.slf4j.Slf4j;

/**
 * 2.6 线程优先级
 *
 * @author jailmango
 * @CreateDate 2020/9/24
 * @see com.jailmango.concurrence.book.action.chapter02
 * @since R9.0
 */
@Slf4j
public class Case2_6 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        HighPriorityThread ht = new HighPriorityThread();
        ht.setPriority(Thread.MAX_PRIORITY);
        LowPriorityThread lt = new LowPriorityThread();
        lt.setPriority(Thread.MIN_PRIORITY);
        lt.start();
        ht.start();
    }

    private static class HighPriorityThread extends Thread {
        private static int count = 0;

        @Override
        public void run() {
            while (true) {
                synchronized (Case2_6.class) {
                    count++;

                    if (count > 1000000) {
                        log.info("High-Priority end...");
                        break;
                    }
                }
            }
        }
    }

    private static class LowPriorityThread extends Thread {
        private static int count = 0;

        @Override
        public void run() {
            while (true) {
                synchronized (Case2_6.class) {
                    count++;

                    if (count > 1000000) {
                        log.info("Low-Priority end...");
                        break;
                    }
                }
            }
        }
    }
}
