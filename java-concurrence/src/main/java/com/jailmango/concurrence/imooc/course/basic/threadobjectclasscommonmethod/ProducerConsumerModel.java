package com.jailmango.concurrence.imooc.course.basic.threadobjectclasscommonmethod;

import java.util.Date;
import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ProducerConsumerModel <br/>
 * 生产者消费者模式，用wait/notify实现
 * 
 * @author he.gang33
 * @CreateDate 2020/5/2
 * @see com.jailmango.concurrence.imooc.course.basic.threadobjectclasscommonmethod
 * @since R9.0
 */
public class ProducerConsumerModel {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ProducerConsumerModel.class);

    public static void main(String[] args) {
        EventStorage storage = new EventStorage(10, new LinkedList<>());
        Producer producer = new Producer(storage);
        Consumer consumer = new Consumer(storage);

        new Thread(producer).start();
        new Thread(consumer).start();
    }

    private static class Producer implements Runnable {

        private EventStorage storage;

        public Producer(EventStorage storage) {
            this.storage = storage;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                storage.put();
            }
        }
    }

    private static class Consumer implements Runnable {

        private EventStorage storage;

        public Consumer(EventStorage storage) {
            this.storage = storage;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                storage.take();
            }
        }
    }

    private static class EventStorage {

        private int size;

        private LinkedList<Date> storage;

        public EventStorage(int size, LinkedList<Date> storage) {
            this.size = size;
            this.storage = storage;
        }

        public synchronized void put() {
            while (storage.size() == size) {
                try {
                    wait();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            storage.add(new Date());
            logger.info("已经有{}个产品了。。。", storage.size());
            notify();
        }

        public synchronized void take() {
            while (storage.size() == 0) {
                try {
                    wait();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            logger.info("消费了{}，还剩下{}个产品", storage.poll(), storage.size());
            notify();
        }
    }
}
