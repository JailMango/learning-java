package com.jailmango.concurrence.book.core.chapter02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case2_1_9 - 2.1.9 出现异常，锁自动释放
 *
 * @author he.gang33
 * @CreateDate 2019-05-24
 * @see com.jailmango.concurrence.book.core.chapter02
 * @since R9.0
 */
public class Case2_1_9 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case2_1_9.class);

    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();

        ThreadA a = new ThreadA(service);
        a.setName("Thread-A");

        ThreadB b = new ThreadB(service);
        b.setName("Thread-B");

        // 线程A出现了异常并释放了锁，线程B进入同步方法并正常输出。说明出现异常时锁可以自动释放。
        // suspend()和sleep()方法被调用后并不释放锁。
        a.start();
        Thread.sleep(500);
        b.start();
    }

    static class ThreadA extends Thread {

        /**
         * Service
         */
        private Service service;

        /**
         * Constructor
         * 
         * @param service Service
         */
        public ThreadA(Service service) {
            this.service = service;
        }

        @Override
        public void run() {
            service.method();
        }
    }

    static class ThreadB extends Thread {

        /**
         * Service
         */
        private Service service;

        /**
         * Constructor
         *
         * @param service Service
         */
        public ThreadB(Service service) {
            this.service = service;
        }

        @Override
        public void run() {
            service.method();
        }
    }

    static class Service {
        public synchronized void method() {
            if (Thread.currentThread().getName().equals("Thread-A")) {
                logger.info("Thread[{}] run... Time[{}]", Thread.currentThread().getName(), System.currentTimeMillis());

                int i = 1;
                while (i == 1) {
                    if (("" + Math.random()).substring(0, 8).equals("0.123456")) {
                        logger.info("Thread[{}] throw exception... Time[{}]", Thread.currentThread().getName(),
                            System.currentTimeMillis());
                        Integer.parseInt("a");
                    }
                }
            }
            else {
                logger.info("Thread[{}] run... Time[{}]", Thread.currentThread().getName(), System.currentTimeMillis());
            }
        }
    }
}
