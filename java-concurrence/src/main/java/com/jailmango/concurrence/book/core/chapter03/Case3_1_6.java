package com.jailmango.concurrence.book.core.chapter03;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case3_1_6 - 3.1.6/3.1.7 使用wait/notify机制，实现列表大小为5时，线程自动销毁
 *
 * @author jailmango
 * @CreateDate 2019-05-31
 * @see com.jailmango.concurrence.book.core.chapter03
 * @since R9.0
 */
public class Case3_1_6 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case3_1_6.class);

    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();

        ThreadA a = new ThreadA("Thread-A", service);
        ThreadB b = new ThreadB("Thread-B", service);

        a.start();
        Thread.sleep(50);
        b.start();

        // 本例说明了，执行完notify()，并不是立马释放锁。会执行完同步块中的全部内容后，再释放锁。
    }

    static class ThreadA extends Thread {

        private Service service;

        public ThreadA(String name, Service service) {
            super(name);
            this.service = service;
        }

        @Override
        public void run() {
            service.waitMethod();
        }
    }

    static class ThreadB extends Thread {

        private Service service;

        public ThreadB(String name, Service service) {
            super(name);
            this.service = service;
        }

        @Override
        public void run() {
            service.notifyMethod();
        }
    }

    static class Service {

        private Object lock = new Object();

        private MyList list = new MyList();

        public void waitMethod() {
            try {
                logger.info("Thread[{}] before wait lock... Time[{}]", Thread.currentThread().getName(),
                    System.currentTimeMillis());
                synchronized (lock) {
                    if (5 != MyList.size()) {
                        logger.info("Thread[{}] wait begin... Time[{}]", Thread.currentThread().getName(),
                            System.currentTimeMillis());
                        lock.wait();
                        logger.info("Thread[{}] wait end... Time[{}]", Thread.currentThread().getName(),
                            System.currentTimeMillis());
                    }
                }
                logger.info("Thread[{}] after wait lock... Time[{}]", Thread.currentThread().getName(),
                    System.currentTimeMillis());
            }
            catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }
        }

        public void notifyMethod() {
            try {
                logger.info("Thread[{}] before notify lock... Time[{}]", Thread.currentThread().getName(),
                    System.currentTimeMillis());
                synchronized (lock) {
                    for (int i = 0; i < 10; i++) {
                        MyList.add(i);

                        if (5 == MyList.size()) {
                            lock.notify();
                            logger.info("Thread[{}] send notify messge... Time[{}]", Thread.currentThread().getName(),
                                System.currentTimeMillis());
                        }

                        logger.info("Thread[{}] add {} in list... Time[{}]", Thread.currentThread().getName(), i,
                            System.currentTimeMillis());
                        Thread.sleep(1000);
                    }
                }
                logger.info("Thread[{}] after notify lock... Time[{}]", Thread.currentThread().getName(),
                    System.currentTimeMillis());
            }
            catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }
        }
    }

    static class MyList {

        private static List<Integer> list = new ArrayList<>();

        public static void add(Integer i) {
            list.add(i);
        }

        public static int size() {
            return list.size();
        }
    }
}
