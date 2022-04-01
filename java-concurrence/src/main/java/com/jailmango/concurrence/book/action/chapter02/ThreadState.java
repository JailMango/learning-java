package com.jailmango.concurrence.book.action.chapter02;

/**
 * 线程状态
 *
 * @author jailmango
 * @CreateDate 2020/9/18
 * @see com.jailmango.concurrence.book.action.chapter02
 * @since R9.0
 */
public class ThreadState {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        // Thread-1 一直处于Runnable状态
        // Thread-2 处于Blocked状态
        Object lock = new Object();
        Runnable runnable1 = () -> {
            while (true) {
                synchronized (lock) {
                    while (true) {

                    }
                }
            }
        };

        Thread thread1 = new Thread(runnable1, "Thread-1");
        Thread thread2 = new Thread(runnable1, "Thread-2");

        thread1.start();
        Thread.sleep(10);
        thread2.start();
    }
}
