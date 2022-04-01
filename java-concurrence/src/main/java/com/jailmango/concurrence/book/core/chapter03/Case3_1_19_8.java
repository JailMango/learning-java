package com.jailmango.concurrence.book.core.chapter03;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case3_1_19_8 - 3.1.19 - 8. 允许连续生产多个，允许连续消费多个
 *
 * @author jailmango
 * @CreateDate 2019-06-04
 * @see com.jailmango.concurrence.book.core.chapter03
 * @since R9.0
 */
public class Case3_1_19_8 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case3_1_19_8.class);

    public static void main(String[] args) {
        Box box = new Box();
        Producer producer = new Producer(box);
        ProduceThread[] pts = new ProduceThread[4];

        for (int i = 0; i < 4; i++) {
            pts[i] = new ProduceThread("Producer-" + i, producer);
        }

        for (ProduceThread pt : pts) {
            pt.start();
        }

        ProduceCheckThread pct = new ProduceCheckThread("Producer-Check", producer);
        pct.start();

        Consumer consumer = new Consumer(box);
        ConsumeThread[] cts = new ConsumeThread[10];

        for (int i = 0; i < 10; i++) {
            cts[i] = new ConsumeThread("Consumer-" + i, consumer);
        }

        for (int i = 0; i < 10; i++) {
            cts[i].start();
        }

        ConsumeCheckThread cct = new ConsumeCheckThread("Consumer-Check", consumer);
        cct.start();
    }

    static class ProduceThread extends Thread {

        private Producer producer;

        public ProduceThread(String name, Producer producer) {
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

    static class ProduceCheckThread extends Thread {

        private Producer producer;

        public ProduceCheckThread(String name, Producer producer) {
            super(name);
            this.producer = producer;
        }

        @Override
        public void run() {
            producer.checkStatus();
        }
    }

    static class ConsumeThread extends Thread {

        private Consumer consumer;

        public ConsumeThread(String name, Consumer consumer) {
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

    static class ConsumeCheckThread extends Thread {

        private Consumer consumer;

        public ConsumeCheckThread(String name, Consumer consumer) {
            super(name);
            this.consumer = consumer;
        }

        @Override
        public void run() {
            consumer.checkStatus();
        }
    }

    static class Producer {

        private Box box;

        public Producer(Box box) {
            this.box = box;
        }

        public void produce() {
            try {
                synchronized (this) {
                    while (box.size() >= 30) {
                        logger.info("Thread[{}] box is full. Waiting...", Thread.currentThread().getName());
                        this.wait();
                    }
                }

                // 这样写法，由于add操作
                Thread.sleep(300);
                box.add();
            }
            catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }
        }

        public void checkStatus() {
            try {
                while (true) {
                    synchronized (this) {
                        if (box.size() < 30) {
                            this.notifyAll();
                        }
                    }
                    Thread.sleep(1000);
                    logger.info("Thread[{}] check size. Size[{}]...", Thread.currentThread().getName(), box.size());
                }
            }
            catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }
        }
    }

    static class Consumer {

        private Box box;

        public Consumer(Box box) {
            this.box = box;
        }

        public void consume() {
            try {
                synchronized (this) {
                    while (box.size() == 0) {
                        logger.info("Thread[{}] box is empty. Waiting...", Thread.currentThread().getName());
                        this.wait();
                    }
                    box.get();
                }
                Thread.sleep(300);
            }
            catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }
        }

        public void checkStatus() {
            try {
                while (true) {
                    synchronized (this) {
                        if (box.size() > 0) {
                            this.notifyAll();
                        }
                    }
                    Thread.sleep(1000);
                    logger.info("Thread[{}] check size. Size[{}]...", Thread.currentThread().getName(), box.size());
                }
            }
            catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }
        }
    }

    static class Box {

        private List<String> list = new ArrayList<>();

        private int count = 0;

        public synchronized int size() {
            return list.size();
        }

        public synchronized void add() {
            if (size() < 30) {
                String value = System.currentTimeMillis() + "_" + Thread.currentThread().getName();
                list.add(value);
                logger.info("Thread[{}] add [{}]. Size[{}]...", Thread.currentThread().getName(), value, size());
                count++;
            }
            else {
                count++;
                logger.info("△△△△△△△△△△△△△△△ Count: [{}] △△△△△△△△△△△△△△△", count);
            }
        }

        public synchronized String get() {
            String value = list.remove(0);
            logger.info("Thread[{}] get [{}]. Size[{}]...", Thread.currentThread().getName(), value, size());
            return value;
        }
    }
}
