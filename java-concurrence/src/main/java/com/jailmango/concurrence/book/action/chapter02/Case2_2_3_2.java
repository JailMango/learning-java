package com.jailmango.concurrence.book.action.chapter02;

import lombok.extern.slf4j.Slf4j;

/**
 * 2.2.3 中断线程 <br/>
 * 使用interrupt(), 可以响应wait() sleep()等
 *
 * @author jailmango
 * @CreateDate 2020/9/16
 * @see com.jailmango.concurrence.book.action.chapter02
 * @since R9.0
 */
@Slf4j
public class Case2_2_3_2 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread();
        thread.start();

        Thread.sleep(1000);
        log.info("Thread-Main interrupt MyThread...");
        thread.interrupt();
        thread.join();

        log.info("Thread-Main end...");
    }

    private static class MyThread extends Thread {

        public MyThread() {
        }

        @Override
        public void run() {
            while (true) {
                if (this.isInterrupted()) {
                    log.info("stop...");
                    break;
                }

                log.info("doing...");
                Thread.yield();
            }
        }
    }

}
