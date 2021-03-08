package com.jailmango.concurrence.exercise;

import lombok.extern.slf4j.Slf4j;

/**
 * 线程间通信 <br/>
 * B在A全部打印完后再开始打印
 *
 * @author he.gang33
 * @CreateDate 2021/2/25
 * @see com.jailmango.concurrence.exercise
 * @since R9.0
 */
@Slf4j
public class 两个线程依次执行 {

    private static final int N = 1000;

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Thread a = new Thread(() -> doWork());
        Thread b = new Thread(() -> {
            log.info("B等待A...");
            try {
                a.join();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            doWork();
        });

        a.start();
        b.start();
    }

    private static class RunnableA implements Runnable {

        @Override
        public void run() {
            doWork();
        }
    }

    private static class RunnableB implements Runnable {

        @Override
        public void run() {
            doWork();
        }
    }

    private static void doWork() {
        for (int i = 0; i < N; i++) {
            log.info("{}", i);
        }
    }
}
