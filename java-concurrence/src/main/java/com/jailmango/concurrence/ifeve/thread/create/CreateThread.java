package com.jailmango.concurrence.ifeve.thread.create;

/**
 * CreateThread 线程创建
 * 
 * @author he.gang33
 * @CreateDate 2018/10/17
 * @see com.jailmango.java.concurrence.ifeve
 * @since R9.0<br>
 */
public class CreateThread {

    /**
     * main
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        // 1. 继承Thread
        MyThread myThread = new MyThread();
        myThread.start();

        // 2. Thread匿名类, 两种写法等价
        // Thread anonymousThread = new Thread() {
        // @Override
        // public void run() {
        // System.out.println("AnonymousThread is running...");
        // }
        // };
        Thread anonymousThread = new Thread(() -> System.out.println("AnonymousThread is running..."));
        anonymousThread.start();

        // 3. 实现Runnable接口
        Thread myRunnable = new Thread(new MyRunnable());
        myRunnable.start();

        // 4. Runnable匿名类
        // Runnable anonymousRunnable = () -> System.out.println("AnonymousRunnable is runnning...");
        // Thread anonymousRunnableThread = new Thread(anonymousRunnable);
        Thread anonymousRunnableThread = new Thread(() -> System.out.println("AnonymousRunnable is runnning..."));
        anonymousRunnableThread.start();
    }
}

class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("MyThread is running...");
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("MyRunnable is running...");
    }
}