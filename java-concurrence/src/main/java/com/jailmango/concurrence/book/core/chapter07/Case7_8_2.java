package com.jailmango.concurrence.book.core.chapter07;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 7.8.1 线程组内处理异常 <br/>
 * 线程组内某个线程出问题，影响其他线程
 *
 * @author jailmango
 * @CreateDate 2020/9/10
 * @see com.jailmango.concurrence.book.core.chapter07
 * @since R9.0
 */
public class Case7_8_2 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case7_8_2.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        MyThreadGroup group = new MyThreadGroup("Thread-Group-Name");
        MyThread[] threads = new MyThread[10];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new MyThread(group, "Thread-" + i, "0");
            threads[i].start();
        }

        Thread.sleep(2000);

        MyThread exThread = new MyThread(group, "Exception-Thread", "a");
        exThread.start();
    }

    private static class MyThreadGroup extends ThreadGroup {

        public MyThreadGroup(String name) {
            super(name);
        }

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            super.uncaughtException(t, e);
            this.interrupt();
        }
    }

    private static class MyThread extends Thread {

        private String num;

        public MyThread(ThreadGroup group, String name, String num) {
            super(group, name);
            this.num = num;
        }

        @Override
        public void run() {
            int number = Integer.parseInt(this.num);

            while (!this.isInterrupted()) {
                logger.info("looping...");
            }
        }
    }
}
