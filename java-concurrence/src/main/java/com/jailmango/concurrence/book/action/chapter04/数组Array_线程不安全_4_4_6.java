package com.jailmango.concurrence.book.action.chapter04;

import lombok.extern.slf4j.Slf4j;

/**
 * 无锁数组_AtomicIntegerArray_4_4_6
 *
 * @author jailmango
 * @CreateDate 2020/10/12
 * @see com.jailmango.concurrence.book.action.chapter04
 * @since R9.0
 */
@Slf4j
public class 数组Array_线程不安全_4_4_6 {

    static int [] array = new int[10];

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

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    private static class MyRunnable implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                array[i % array.length] += i % array.length;
            }
        }
    }
}
