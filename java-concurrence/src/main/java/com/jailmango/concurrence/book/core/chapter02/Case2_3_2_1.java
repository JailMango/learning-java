package com.jailmango.concurrence.book.core.chapter02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case2_3_2_1
 *
 * @author jailmango
 * @CreateDate 2019-05-30
 * @see com.jailmango.concurrence.book.core.chapter02
 * @since R9.0
 */
public class Case2_3_2_1 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case2_3_2_1.class);

    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();

        MyThread1 a = new MyThread1("Thread-A", service);
        MyThread2 b = new MyThread2("Thread-B", service);
        a.start();
        b.start();

        Thread.sleep(1000);
        logger.info("1L Binary String[{}]", Long.toBinaryString(1));
        logger.info("-1L Binary String[{}]", Long.toBinaryString(-1));

        // 64位JDK中，long和double是原子的。

        while (true) {
            long value = service.i;

            if (1L != value && -1L != value) {
                logger.info("i = {}... Binary String[{}]", value, Long.toBinaryString(value));
            }
            else {
                logger.info("Atomic... i = {}... Binary String[{}]", value, Long.toBinaryString(value));
            }

            Thread.sleep(1000);
        }
    }

    static class MyThread1 extends Thread {

        private Service service;

        public MyThread1(String name, Service service) {
            super(name);
            this.service = service;
        }

        @Override
        public void run() {
            while (true) {
                service.i = 1;
            }
        }
    }

    static class MyThread2 extends Thread {

        private Service service;

        public MyThread2(String name, Service service) {
            super(name);
            this.service = service;
        }

        @Override
        public void run() {
            while (true) {
                service.i = -1;
            }
        }
    }

    static class Service {

        public long i;
    }
}
