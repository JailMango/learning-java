package com.jailmango.concurrence.book.core.chapter03;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case3_1_18_1 - 3.1.18 wait条件发生变化与使用while的必要性 - 复现问题的示例
 *
 * @author jailmango
 * @CreateDate 2019-06-03
 * @see com.jailmango.concurrence.book.core.chapter03
 * @since R9.0
 */
public class Case3_1_18_1 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case3_1_18_1.class);

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Add add = new Add(lock);
        Subtract subtract = new Subtract(lock);

        ThreadSubtract b = new ThreadSubtract("Thread-Subtract-1", subtract);
        b.start();
        Thread.sleep(1000);
        ThreadSubtract c = new ThreadSubtract("Thread-Subtract-2", subtract);
        c.start();
        Thread.sleep(2000);
        ThreadAdd a = new ThreadAdd("Thread-Add", add);
        a.start();

        // 由于启动了两个remove()操作的线程，启动了一个add()操作的线程。因此会出现下标越界的异常。
    }

    static class Add {

        private Object lock;

        public Add(Object lock) {
            this.lock = lock;
        }

        public void add() {
            synchronized (lock) {
                ValueObject.list.add("anything...");
                logger.info("Thread[{}] add [{}] into list... Time[{}]", Thread.currentThread().getName(), "anything",
                    System.currentTimeMillis());
                lock.notifyAll();
                logger.info("Thread[{}] notify all other threads... Time[{}]", Thread.currentThread().getName(),
                    System.currentTimeMillis());
            }
        }
    }

    static class Subtract {

        private Object lock;

        public Subtract(Object lock) {
            this.lock = lock;
        }

        public void subtract() {
            try {
                synchronized (lock) {
                    if (ValueObject.list.size() == 0) {
                        logger.info("Thread[{}] list is empty. wait begin... Time[{}]",
                            Thread.currentThread().getName(), System.currentTimeMillis());
                        lock.wait();
                        logger.info("Thread[{}] wait end... Time[{}]", Thread.currentThread().getName(),
                            System.currentTimeMillis());
                    }
                    logger.info("Thread[{}] remove [{}] from list... Time[{}]", Thread.currentThread().getName(),
                        ValueObject.list.get(0), System.currentTimeMillis());
                    ValueObject.list.remove(0);
                    logger.info("Thread[{}] list size is [{}]... Time[{}]", Thread.currentThread().getName(),
                        ValueObject.list.size(), System.currentTimeMillis());
                }
            }
            catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }
        }
    }

    static class ThreadAdd extends Thread {

        private Add service;

        public ThreadAdd(String name, Add add) {
            super(name);
            this.service = add;
        }

        @Override
        public void run() {
            service.add();
        }
    }

    static class ThreadSubtract extends Thread {

        private Subtract service;

        public ThreadSubtract(String name, Subtract subtract) {
            super(name);
            this.service = subtract;
        }

        @Override
        public void run() {
            service.subtract();
        }
    }

    static class ValueObject {
        public static List<String> list = new ArrayList<>();
    }
}
