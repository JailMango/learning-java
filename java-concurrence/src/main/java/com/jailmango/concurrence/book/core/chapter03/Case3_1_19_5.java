package com.jailmango.concurrence.book.core.chapter03;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case3_1_19_5 - 3.1.19 - 5. 1个生产者与多个消费者: 操作栈(解决wait条件改变与假死)
 *
 * @author he.gang33
 * @CreateDate 2019-06-04
 * @see com.jailmango.concurrence.book.core.chapter03
 * @since R9.0
 */
public class Case3_1_19_5 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case3_1_19_5.class);

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        Producer producer = new Producer(stack);
        Consumer consumer = new Consumer(stack);

        ProducerThread pt = new ProducerThread("Producer-0", producer);

        ConsumerThread[] cts = new ConsumerThread[5];
        for (int i = 0; i < 5; i++) {
            cts[i] = new ConsumerThread("Consumer-" + i, consumer);
        }

        pt.start();

        for (int i = 0; i < 5; i++) {
            cts[i].start();
        }
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
                while (this.list.size() == 1) {
                    logger.info("Thread[{}] list is full. Waiting...", Thread.currentThread().getName());
                    Thread.sleep(1000);
                    this.wait();
                }

                list.add(System.currentTimeMillis() + "_" + Thread.currentThread().getName());
                this.notifyAll();
                logger.info("Thread[{}] list is empty. Add {} into list...", Thread.currentThread().getName(),
                    list.get(0));
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }
        }

        public synchronized String pop() {
            String value = "";

            try {
                while (this.list.size() == 0) {
                    logger.info("Thread[{}] list is empty. Waiting...", Thread.currentThread().getName());
                    Thread.sleep(1000);
                    this.wait();
                }

                value = list.get(0);
                list.remove(0);
                this.notifyAll();
                logger.info("Thread[{}] list is full. Get {} from list...", Thread.currentThread().getName(), value);
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }

            return value;
        }
    }
}
