package com.jailmango.concurrence.book.action.chapter08;

import java.util.ArrayList;

/**
 * UnsafeArrayList
 *
 * @author he.gang33
 * @CreateDate 2020/11/14
 * @see com.jailmango.concurrence.book.action.chapter08
 * @since R9.0
 */
public class UnsafeArrayList {

    static ArrayList<Object> al = new ArrayList<>();

    static class AddTask implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < 1000000; i++) {
                al.add(new Object());
            }
        }
    }

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Thread t1 = new Thread(new AddTask(), "t1");
        Thread t2 = new Thread(new AddTask(), "t2");
        t1.start();
        t2.start();

        Thread t3 = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t3");
        t3.start();
    }
}
