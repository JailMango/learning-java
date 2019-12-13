package com.jailmango.concurrence.book.core.chapter03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case3_1_19_1 - 3.1.19 生产者/消费者模式实现 - 1. 1个生产者1个消费者: 操作值
 *
 * @author he.gang33
 * @CreateDate 2019-06-03
 * @see com.jailmango.concurrence.book.core.chapter03
 * @since R9.0
 */
public class Case3_1_19_1 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case3_1_19_1.class);

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();

        Thread producerThread = new Thread(() -> {
            Producer producer = new Producer(lock);

            while (true) {
                producer.produce();
            }
        });
        producerThread.setName("Producer");

        Thread consumerThread = new Thread(() -> {
            Consumer consumer = new Consumer(lock);

            while (true) {
                consumer.consume();
            }
        });
        consumerThread.setName("Consumer");

        consumerThread.start();
        Thread.sleep(100);
        producerThread.start();

        // 本例，1个生产者和1个消费者，无问题
    }

    static class Producer {

        private Object lock;

        public Producer(Object lock) {
            this.lock = lock;
        }

        public void produce() {
            try {
                synchronized (lock) {
                    if (!ValObj.value.equals("")) {
                        // 值不为空，不再生产，等待消费者消费
                        logger.info("Producer[{}] is waiting...", Thread.currentThread().getName());
                        lock.wait();
                    }

                    logger.info("Producer[{}] wake up...", Thread.currentThread().getName());
                    String value = System.currentTimeMillis() + "_" + Thread.currentThread().getName();
                    ValObj.value = value;
                    logger.info("Producer[{}] produce [{}]", Thread.currentThread().getName(), value);
                    Thread.sleep(800);
                    lock.notify();
                }
            }
            catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }
        }
    }

    static class Consumer {

        private Object lock;

        public Consumer(Object lock) {
            this.lock = lock;
        }

        public void consume() {
            try {
                synchronized (lock) {
                    if (ValObj.value.equals("")) {
                        // 值为空，不再消费，等待生产者生产
                        logger.info("Consumer[{}] is waiting...", Thread.currentThread().getName());
                        lock.wait();
                    }

                    logger.info("Consumer[{}] wake up...", Thread.currentThread().getName());
                    logger.info("Consumer[{}] consume [{}]", Thread.currentThread().getName(), ValObj.value);
                    ValObj.value = "";
                    lock.notify();
                    Thread.sleep(800);
                }
            }
            catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }
        }
    }

    static class ValObj {
        public static String value = "";
    }
}
