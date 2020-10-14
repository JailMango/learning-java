package com.jailmango.concurrence.book.action.chapter02;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * 2.8.2 ArrayList的线程安全问题
 *
 * @author he.gang33
 * @CreateDate 2020/9/28
 * @see com.jailmango.concurrence.book.action.chapter02
 * @since R9.0
 */
@Slf4j
public class Case2_8_2 {

    // ArrayList是线程不安全的
    private static List<Integer> list = new ArrayList<>();

    // Vector是线程安全的
    // private static List<Integer> list = new Vector<>();

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new ArrayListRunnable();
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        log.info("Size -> {}", list.size());
    }

    private static class ArrayListRunnable implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                list.add(i);
            }
        }
    }
}
