package com.jailmango.concurrence.book.action.chapter02;

import lombok.extern.slf4j.Slf4j;

/**
 * 2.5 守护线程Daemon <br/>
 * 当应用内只有守护线程，则JVM自然退出
 *
 * @author he.gang33
 * @CreateDate 2020/9/21
 * @see com.jailmango.concurrence.book.action.chapter02
 * @since R9.0
 */
@Slf4j
public class Case2_5_1 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        DaemonThread dt = new DaemonThread();
        dt.setDaemon(true);
        dt.start();

        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class DaemonThread extends Thread {

        @Override
        public void run() {
            while (true) {
                log.info("doing...");

                try {
                    Thread.sleep(200);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
