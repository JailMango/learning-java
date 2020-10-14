package com.jailmango.concurrence.book.action.extra;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * SynchronizedCase
 *
 * @author he.gang33
 * @CreateDate 2020/9/16
 * @see com.jailmango.concurrence.book.action.extra
 * @since R9.0
 */
@Slf4j
public class SynchronizedCase {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        Cal cal = Cal.builder().build();
        Runnable plusRunnable = () -> cal.plus();
        Runnable minusRunnable = () -> cal.minus();

        Thread plusThread = new Thread(plusRunnable);
        Thread minusThread = new Thread(minusRunnable);
        plusThread.start();
        minusThread.start();

        plusThread.join();
        minusThread.join();

        log.info("Thread-Main end...");
    }

    @Data
    @Builder
    private static class Cal {

        public synchronized void plus() {
            log.info("synchronized plus...");
            try {
                Thread.sleep(3000);
            }
            catch (InterruptedException e) {
                log.info("Catch InterruptedException...");
                e.printStackTrace();
            }
        }

        public synchronized void minus() {
            log.info("synchronized minus...");
            try {
                Thread.sleep(3000);
            }
            catch (InterruptedException e) {
                log.info("Catch InterruptedException...");
                e.printStackTrace();
            }
        }
    }
}
