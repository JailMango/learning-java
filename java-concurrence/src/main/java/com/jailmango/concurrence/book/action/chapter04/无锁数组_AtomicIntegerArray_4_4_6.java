package com.jailmango.concurrence.book.action.chapter04;

import java.util.concurrent.atomic.AtomicIntegerArray;

import lombok.extern.slf4j.Slf4j;

/**
 * 无锁数组_AtomicIntegerArray_4_4_6
 *
 * @author he.gang33
 * @CreateDate 2020/10/12
 * @see com.jailmango.concurrence.book.action.chapter04
 * @since R9.0
 */
@Slf4j
public class 无锁数组_AtomicIntegerArray_4_4_6 {

    static AtomicIntegerArray array = new AtomicIntegerArray(10);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        Thread[] ts = new Thread[10];

        for (int i = 0; i < 10; i++) {
            ts[i] = new Thread(new MyRunnable());

        }
        for (int i = 0; i < 10; i++) {
            ts[i].start();

        }
        for (int i = 0; i < 10; i++) {
            ts[i].join();

        }

        System.out.println(array);
    }

    private static class MyRunnable implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                array.getAndIncrement(i % array.length());
            }
        }
    }
}
