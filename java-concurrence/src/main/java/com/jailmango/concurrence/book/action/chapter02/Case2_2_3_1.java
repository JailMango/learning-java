package com.jailmango.concurrence.book.action.chapter02;

import lombok.extern.slf4j.Slf4j;

/**
 * 2.2.3 中断线程 <br/>
 * 自行设置的中断标记位，无法响应wait() sleep()等
 *
 * @author he.gang33
 * @CreateDate 2020/9/16
 * @see com.jailmango.concurrence.book.action.chapter02
 * @since R9.0
 */
@Slf4j
public class Case2_2_3_1 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread();
        thread.start();

        Thread.sleep(3000);
        log.info("Thread-Main stop MyThread...");
        thread.stopMe();
        thread.join();

        log.info("Thread-Main end...");
    }

    private static class MyThread extends Thread {

        private volatile boolean stop = false;

        public MyThread() {
        }

        public void stopMe() {
            this.stop = true;
        }

        @Override
        public void run() {
            while (true) {
                if (this.stop) {
                    log.info("stop...");
                    break;
                }
                synchronized (this) {
                    try {
                        log.info("doing...");
                        wait();
                    }
                    catch (InterruptedException e) {
                        log.info("catch InterruptedException...");
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
