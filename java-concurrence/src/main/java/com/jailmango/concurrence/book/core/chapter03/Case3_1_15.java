package com.jailmango.concurrence.book.core.chapter03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case3_1_15 - 3.1.15 wait(long)方法的基本使用
 *
 * @author he.gang33
 * @CreateDate 2019-06-03
 * @see com.jailmango.concurrence.book.core.chapter03
 * @since R9.0
 */
public class Case3_1_15 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case3_1_15.class);

    public static void main(String[] args) throws InterruptedException {

    }

    /**
     * 示例2 - 手动唤醒
     * @throws InterruptedException InterruptedException
     */
    private static void Case2() throws InterruptedException {
        Object lock = new Object();
        MyThreadA a = new MyThreadA("Wait-Thread", lock);
        MyThreadB b = new MyThreadB("Notify-Thread", lock);

        a.start();
        Thread.sleep(3000);
        b.start();

        // wait(long)时段内，其他线程手动唤醒。
    }

    /**
     * 示例1 - 自动唤醒
     */
    private static void case1() {
        Object lock = new Object();
        MyThreadA a = new MyThreadA("Wait-Thread", lock);
        a.start();
        // 可在5000ms后自动唤醒。
        // wait(long)功能是等待一段时间内是否有其他线程对锁进行notify通知唤醒。若超过这个时间，则自动唤醒，能继续向下运行的前提是持有锁。
    }

    static class MyThreadA extends Thread {

        private Object lock;

        public MyThreadA(String name, Object lock) {
            super(name);
            this.lock = lock;
        }

        @Override
        public void run() {
            try {
                synchronized (lock) {
                    logger.info("Thread[{}] wait begin... Time[{}]", Thread.currentThread().getName(),
                        System.currentTimeMillis());
                    lock.wait(5000);
                    logger.info("Thread[{}] wait end... Time[{}]", Thread.currentThread().getName(),
                        System.currentTimeMillis());
                }
            }
            catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }
        }
    }

    static class MyThreadB extends Thread {

        private Object lock;

        public MyThreadB(String name, Object lock) {
            super(name);
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock) {
                logger.info("Thread[{}] notify begin... Time[{}]", Thread.currentThread().getName(),
                    System.currentTimeMillis());
                lock.notify();
                logger.info("Thread[{}] notify end... Time[{}]", Thread.currentThread().getName(),
                    System.currentTimeMillis());
            }
        }
    }
}
