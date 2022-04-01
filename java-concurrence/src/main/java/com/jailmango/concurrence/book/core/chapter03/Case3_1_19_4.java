package com.jailmango.concurrence.book.core.chapter03;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case3_1_19_4 - 3.1.19 - 4. 1个生产者1个消费者: 操作栈
 *
 * @author jailmango
 * @CreateDate 2019-06-04
 * @see com.jailmango.concurrence.book.core.chapter03
 * @since R9.0
 */
public class Case3_1_19_4 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case3_1_19_4.class);

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        Producer producer = new Producer(stack);
        Consumer consumer = new Consumer(stack);

        ProducerThread pt = new ProducerThread("Producer-0", producer);
        ConsumerThread ct = new ConsumerThread("Consumer-0", consumer);

        pt.start();
        ct.start();

        // 生产者与消费者交替运行
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

    static class Producer {

        private MyStack stack;

        public Producer(MyStack stack) {
            this.stack = stack;
        }

        public void produce() {
            stack.push();
        }
    }

    static class Consumer {

        private MyStack stack;

        public Consumer(MyStack stack) {
            this.stack = stack;
        }

        public void consume() {
            logger.info("Consume {}...", stack.pop());
        }
    }

    static class MyStack {

        private List<String> list = new ArrayList<>();

        public synchronized void push() {
            try {
                if (this.list.size() == 1) {
                    logger.info("Thread[{}] list is full. Waiting...", Thread.currentThread().getName());
                    this.wait();
                }

                list.add(System.currentTimeMillis() + "_" + Thread.currentThread().getName());
                this.notify();
                logger.info("Thread[{}] list is empty. Add {} into list...", Thread.currentThread().getName(),
                    list.get(0));
            }
            catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }
        }

        public synchronized String pop() {
            String value = "";

            try {
                if (this.list.size() == 0) {
                    logger.info("Thread[{}] list is empty. Waiting...", Thread.currentThread().getName());
                    this.wait();
                }

                value = list.get(0);
                list.remove(0);
                this.notify();
                logger.info("Thread[{}] list is full. Get {} from list...", Thread.currentThread().getName(), value);
            }
            catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }

            return value;
        }
    }
}
