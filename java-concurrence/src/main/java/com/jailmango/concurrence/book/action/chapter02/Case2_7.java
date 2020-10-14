package com.jailmango.concurrence.book.action.chapter02;

import lombok.extern.slf4j.Slf4j;

/**
 * 2.7 线程安全的概念和synchronized关键字 <br/>
 * volatile只可保证可见性，无法保证线程安全
 *
 * @author he.gang33
 * @CreateDate 2020/9/28
 * @see com.jailmango.concurrence.book.action.chapter02
 * @since R9.0
 */
@Slf4j
public class Case2_7 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        Counter runnable = new Counter();
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        log.info("i = {}", runnable.count);
    }

    private static class Counter implements Runnable {

        public volatile int count = 0;

        private Object lock = new Object();

        @Override
        public void run() {
            for (int i = 0; i < 100000; i++) {
                // 使用synchronized可以解决该问题
                // synchronized (lock) {
                //     increse();
                // }

                increse();
            }
        }

        private void increse() {
            count++;
        }
    }
}
