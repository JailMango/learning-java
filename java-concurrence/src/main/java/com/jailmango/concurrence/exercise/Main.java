package com.jailmango.concurrence.exercise;

/**
 * Main
 *
 * @author jailmango
 * @CreateDate 2020/4/27
 * @see com.jailmango.concurrence.exercise
 * @since R9.0
 */
public class Main {

    public static void main(String[] args) {
        SharedData data = new SharedData();
        Consumer consumer = new Consumer(data);
        Thread ct = new Thread(consumer);
        Producer producer = new Producer(data);
        Thread pt = new Thread(producer);

        ct.start();
        pt.start();
    }
}
