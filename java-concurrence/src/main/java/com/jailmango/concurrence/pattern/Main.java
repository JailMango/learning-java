package com.jailmango.concurrence.pattern;

/**
 * Main
 *
 * @author he.gang33
 * @CreateDate 2018/11/21
 * @see com.jailmango.java.pattern
 * @since R9.0<br>
 */
public class Main {

    /**
     * main
     * 
     * @param args String[]
     * @throws InterruptedException InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Order order = new Order(10);

        Thread producer = new Thread(new Producer(order), "Producer");
        producer.start();

        Thread.sleep(1000);

        Thread consumerA = new Thread(new Consumer(order), "Consumer-A");
        Thread consumerB = new Thread(new Consumer(order), "Consumer-B");
        Thread consumerC = new Thread(new Consumer(order), "Consumer-C");
        consumerA.start();
        consumerB.start();
        consumerC.start();
    }
}
