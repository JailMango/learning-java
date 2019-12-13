package com.jailmango.concurrence.book.core.chapter02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case2_3_2_3 - 2.3.2 - 3. 关键字volatile int i++的非原子特性
 *
 * @author he.gang33
 * @CreateDate 2019-05-30
 * @see com.jailmango.concurrence.book.core.chapter02
 * @since R9.0
 */
public class Case2_3_2_3 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case2_3_2_3.class);

    public static void main(String[] args) {
        MyThread[] myThreads = new MyThread[100];

        for (int index = 0; index < 100; index++) {
            myThreads[index] = new MyThread();
        }

        for (int index = 0; index < 100; index++) {
            myThreads[index].start();
        }

        // volatile关键字主要使用长
    }

    static class MyThread extends Thread {

        // volatile int i++; 并不能保证原子性。由于本机使用64bit JDK，因此表现不出来。可通过synchronized实现
        // public static volatile int count;
        public static int count;

        @Override
        public void run() {
            add();
        }

        private static synchronized void add() {
            for (int i = 0; i < 100; i++) {
                count++;
            }
            logger.info("Thread[{}] Count = {}", Thread.currentThread().getName(), count);
        }
    }
}
