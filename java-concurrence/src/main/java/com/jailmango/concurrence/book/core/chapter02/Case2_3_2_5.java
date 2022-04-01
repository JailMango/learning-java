package com.jailmango.concurrence.book.core.chapter02;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case2_3_2_5 - 2.3.2 - 5. 出现的逻辑混乱
 *
 * @author jailmango
 * @CreateDate 2019-05-31
 * @see com.jailmango.concurrence.book.core.chapter02
 * @since R9.0
 */
public class Case2_3_2_5 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case2_3_2_5.class);

    public static void main(String[] args) {
        Service service = new Service();
        MyThread[] array = new MyThread[5];

        for (int i = 0; i < 5; i++) {
            array[i] = new MyThread("Thread-" + i, service);
        }

        for (int i = 0; i < 5; i++) {
            array[i].start();
        }

        // 本例输出结果乱序，说明原子类的输出结果具有随机性
        // 虽然addAndGet()方法是原子的。但是方法和方法之间的调用不是原子的，因此会出现上述问题。
        // 可以使用同步来解决
    }

    static class MyThread extends Thread {

        private Service service;

        public MyThread(String name, Service service) {
            super(name);
            this.service = service;
        }

        @Override
        public void run() {
            service.add();
        }
    }

    static class Service {

        private AtomicLong count = new AtomicLong();

        public void add() {
            logger.info("Thread[{}] add 100... Count[{}]", Thread.currentThread().getName(), count.addAndGet(100));
            count.addAndGet(1);
        }

//        public synchronized void add() {
//            logger.info("Thread[{}] add 100... Count[{}]", Thread.currentThread().getName(), count.addAndGet(100));
//            count.addAndGet(1);
//        }
    }
}
