package com.jailmango.exercise.utils.pretty;

import lombok.extern.slf4j.Slf4j;

/**
 * Pretty
 *
 * @author jailmango
 * @CreateDate 2021/2/18
 * @see com.jailmango.exercise.utils.pretty
 * @since R9.0
 */
@Slf4j
public class Pretty {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        MyThread1 t = new MyThread1("my-thread");
        t.start();

        Thread.sleep(10000);

        t.interrupt();

        while (true) {

        }
    }

    private static class MyThread1 extends Thread {

        public volatile boolean exit = false;

        public MyThread1(String name) {
            super(name);
        }

        @Override
        public void run() {
            log.info("my-thread doing...");

            Thread thread = new Thread(() -> {
                while (true) {
                    log.info("daemon...");
                    try {
                        Thread.sleep(500);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            thread.setName("thread-1");
            thread.setDaemon(true);
            thread.start();

            while (!exit) {
                log.info("my-thread doing...");
                try {
                    Thread.sleep(500);
                }
                catch (InterruptedException e) {
                    exit = true;
                    e.printStackTrace();
                }
            }

            thread.interrupt();
        }
    }
}