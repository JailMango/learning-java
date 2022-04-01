package com.jailmango.concurrence.book.action.chapter02;

import lombok.extern.slf4j.Slf4j;

/**
 * 2.3 volatile与JMM(Java内存模型)
 *
 * @author jailmango
 * @CreateDate 2020/9/21
 * @see com.jailmango.concurrence.book.action.chapter02
 * @since R9.0
 */
@Slf4j
public class Case2_3_1 {

    public volatile static long shareData;

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

        private long to;

        public Change(long to) {
            this.to = to;
        }

        @Override
        public void run() {
            while (true) {
                Case2_3_1.shareData = this.to;
                Thread.yield();
            }
        }
    }

    private static class Read implements Runnable {

        @Override
        public void run() {
            while (true) {
                long tmp = Case2_3_1.shareData;

                if (tmp != 111L && tmp != -999L && tmp != 333L && tmp != -444L) {
                    log.info("{}", tmp);
                }
                Thread.yield();
            }
        }
    }
}
