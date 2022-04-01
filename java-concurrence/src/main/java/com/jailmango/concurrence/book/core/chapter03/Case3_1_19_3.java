package com.jailmango.concurrence.book.core.chapter03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case3_1_19_3 - 3.1.19 - 3. 多生产者多消费者: 操作值(假死) 解决Case3_1_19_2假死问题
 *
 * @author jailmango
 * @CreateDate 2019-06-04
 * @see com.jailmango.concurrence.book.core.chapter03
 * @since R9.0
 */
public class Case3_1_19_3 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case3_1_19_3.class);

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Producer producer = new Producer(lock);
        Consumer consumer = new Consumer(lock);

        ProducerThread[] producerThreads = new ProducerThread[2];
        ConsumerThread[] consumerThreads = new ConsumerThread[2];

        for (int i = 0; i < 2; i++) {
            producerThreads[i] = new ProducerThread("Producer-" + i, producer);
            consumerThreads[i] = new ConsumerThread("Consumer-" + i, consumer);
        }

        producerThreads[0].start();
        consumerThreads[0].start();
        consumerThreads[1].start();
        producerThreads[1].start();

        // 使用notifyAll()替换notify()，即可解决假死问题
        Thread.sleep(10000);
        Thread[] threads = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(threads);

        for (Thread thread : threads) {
            logger.info("{} --- {}", thread.getName(), thread.getState());
        }
    }

    static class Producer {

        private Object lock;

        public Producer(Object lock) {
            this.lock = lock;
        }

        public void produce() {
            try {
                synchronized (lock) {
                    while (!ValObj.value.equals("")) {
                        // 值不为空，不再生产，等待消费者消费
                        logger.info("Producer[{}] is waiting...", Thread.currentThread().getName());
                        lock.wait();
                    }

                    logger.info("Producer[{}] wake up...", Thread.currentThread().getName());
                    String value = System.currentTimeMillis() + "_" + Thread.currentThread().getName();
                    ValObj.value = value;
                    logger.info("Producer[{}] produce [{}]", Thread.currentThread().getName(), value);
                    // Thread.sleep(800);
                    lock.notifyAll();
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
                    while (ValObj.value.equals("")) {
                        // 值为空，不再消费，等待生产者生产
                        logger.info("Consumer[{}] is waiting...", Thread.currentThread().getName());
                        lock.wait();
                    }

                    logger.info("Consumer[{}] wake up...", Thread.currentThread().getName());
                    logger.info("Consumer[{}] consume [{}]", Thread.currentThread().getName(), ValObj.value);
                    ValObj.value = "";
                    lock.notifyAll();
                    // Thread.sleep(800);
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

    static class ProducerThread extends Thread {

        private Producer producer;

        public ProducerThread(String name, Producer producer) {
            super(name);
            this.producer = producer;
        }

        @Override
        public void run() {
            while (true) {
                producer.produce();
            }
        }
    }

    static class ConsumerThread extends Thread {

        private Consumer consumer;

        public ConsumerThread(String name, Consumer consumer) {
            super(name);
            this.consumer = consumer;
        }

        @Override
        public void run() {
            while (true) {
                consumer.consume();
            }
        }
    }
}
