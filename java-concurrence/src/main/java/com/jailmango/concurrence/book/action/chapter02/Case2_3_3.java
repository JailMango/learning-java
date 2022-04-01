package com.jailmango.concurrence.book.action.chapter02;

import lombok.extern.slf4j.Slf4j;

/**
 * volatile & JMM(可见性和有序性)
 *
 * @author jailmango
 * @CreateDate 2020/9/21
 * @see com.jailmango.concurrence.book.action.chapter02
 * @since R9.0
 */
@Slf4j
public class Case2_3_3 {

    private volatile static boolean ready;

    private static int number;

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        new Read().start();
        Thread.sleep(2000);

        log.info("change ready and number...");
        number = 42;
        ready = true;
        Thread.sleep(5000);
    }

    private static class Read extends Thread {

        @Override
        public void run() {
            while (!ready) {

            }

            log.info("number = {}", number);
        }
    }
}
