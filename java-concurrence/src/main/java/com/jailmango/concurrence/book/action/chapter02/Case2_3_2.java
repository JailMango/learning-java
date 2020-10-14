package com.jailmango.concurrence.book.action.chapter02;

import lombok.extern.slf4j.Slf4j;

/**
 * 2.3 volatile & JMM
 *
 * @author he.gang33
 * @CreateDate 2020/9/21
 * @see com.jailmango.concurrence.book.action.chapter02
 * @since R9.0
 */
@Slf4j
public class Case2_3_2 {

    public volatile static long i = 0;

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];

        for (int k = 0; k < 10; k++) {
            Runnable target;
            threads[k] = new Thread(new PlusTask());
            threads[k].start();
        }

        for (int k = 0; k < 10; k++) {
            threads[k].join();
        }

        log.info("i = {}", i);
    }

    private static class PlusTask implements Runnable {

        @Override
        public void run() {
            for (int k = 0; k < 1000; k++) {
                i++;
            }
        }
    }

}
