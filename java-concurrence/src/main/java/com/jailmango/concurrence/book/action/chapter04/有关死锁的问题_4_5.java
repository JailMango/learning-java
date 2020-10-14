package com.jailmango.concurrence.book.action.chapter04;

import lombok.extern.slf4j.Slf4j;

/**
 * 有关死锁的问题_4_5
 *
 * @author he.gang33
 * @CreateDate 2020/10/14
 * @see com.jailmango.concurrence.book.action.chapter04
 * @since R9.0
 */
@Slf4j
public class 有关死锁的问题_4_5 {

    private static Object fork1 = new Object();

    private static Object fork2 = new Object();

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        Philosopher a = new Philosopher(fork1);
        Philosopher b = new Philosopher(fork2);
        a.start();
        b.start();

        a.join();
        b.join();

        log.info("end...");
    }

    private static class Philosopher extends Thread {

        private Object tool;

        public Philosopher(Object tool) {
            this.tool = tool;

            if (tool == fork1) {
                this.setName("Philosopher-A");
            }
            else if (tool == fork2) {
                this.setName("Philosopher-B");
            }
        }

        @Override
        public void run() {
            if (this.tool == fork1) {
                synchronized (fork1) {
                    log.info("get fork1...");
                    try {
                        Thread.sleep(500);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (fork2) {
                        log.info("get fork2...");
                        log.info("eating...");
                    }
                }
            }
            else if (this.tool == fork2) {
                synchronized (fork2) {
                    log.info("get fork2...");
                    try {
                        Thread.sleep(500);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (fork1) {
                        log.info("get fork1...");
                        log.info("eating...");
                    }
                }
            }
        }
    }

}
