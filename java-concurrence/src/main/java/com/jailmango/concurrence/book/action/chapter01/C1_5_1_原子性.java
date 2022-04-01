package com.jailmango.concurrence.book.action.chapter01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 1.5.1 原子性
 *
 * @author jailmango
 * @CreateDate 2020/9/14
 * @see com.jailmango.concurrence.book.action.chapter01
 * @since R9.0
 */
public class C1_5_1_原子性 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(C1_5_1_原子性.class);

    /**
     * Shared Data
     */
    public static long shareData = 0;

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        new Thread(new Change(111L)).start();
        new Thread(new Change(-999L)).start();
        new Thread(new Change(333L)).start();
        new Thread(new Change(-444L)).start();
        new Thread(new Read()).start();
    }

    private static class Change implements Runnable {

        private long target;

        public Change(long target) {
            this.target = target;
        }

        @Override
        public void run() {
            while (true) {
                C1_5_1_原子性.shareData = target;
                Thread.yield();
            }
        }
    }

    private static class Read implements Runnable {

        @Override
        public void run() {
            while (true) {
                long tmp = C1_5_1_原子性.shareData;

                if (tmp != 111L && tmp != -999L && tmp != 333L && tmp != -444L) {
                    logger.info("{}", tmp);
                }
                Thread.yield();
            }
        }
    }
}
