package com.jailmango.concurrence.book.action.chapter02;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

/**
 * HashMap的线程安全问题
 *
 * @author jailmango
 * @CreateDate 2020/9/28
 * @see com.jailmango.concurrence.book.action.chapter02
 * @since R9.0
 */
@Slf4j
public class HashMap的线程安全问题 {

    private static Map<String, String> map = new HashMap<>();

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new HashMapRunnable(0));
        Thread t2 = new Thread(new HashMapRunnable(1));

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        log.info("Size -> {}", map.size());
    }

    private static class HashMapRunnable implements Runnable {

        private int start = 0;

        public HashMapRunnable(int start) {
            this.start = start;
        }

        @Override
        public void run() {
            for (int i = start; i < 10000000; i += 2) {
                map.put(Integer.toString(i), Integer.toBinaryString(i));
            }
        }
    }
}
