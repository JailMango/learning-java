package com.jailmango.concurrence.imooc.course.basic.stop;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * WrongWayVolatileCantStopFixed <br/>
 * 用中断来修复WrongWayVolatileCantStop中无尽等待的问题
 *
 * @author he.gang33
 * @CreateDate 2020/4/23
 * @see com.jailmango.concurrence.imooc.course.basic.stop
 * @since R9.0
 */
public class WrongWayVolatileCantStopFixed {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(WrongWayVolatileCantStopFixed.class);

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue storage = new ArrayBlockingQueue(10);

        Producer producer = new Producer(storage);
        Thread producerThread = new Thread(producer);
        producerThread.start();
        Thread.sleep(1000);

        Consumer consumer = new Consumer(storage);
        while (consumer.needMoreNums()) {
            logger.info("{}被消费了...", consumer.getStorage().take());
            Thread.sleep(100);
        }

        logger.info("消费者不要更多数据了...");
        producerThread.interrupt();
    }

    private static class Producer implements Runnable {

        /**
         * logger
         */
        private static final Logger logger = LoggerFactory.getLogger(Producer.class);

        /**
         * BlockingQueue
         */
        private BlockingQueue<Integer> storage;

        /**
         * Constructor
         *
         * @param storage BlockingQueue<Integer>
         */
        public Producer(BlockingQueue<Integer> storage) {
            this.storage = storage;
        }

        @Override
        public void run() {
            int num = 0;

            try {
                while (!Thread.currentThread().isInterrupted() && num <= 100000) {
                    if (num % 100 == 0) {
                        logger.info("{}是100的倍数...", num);
                        storage.put(num);
                    }
                    num++;
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                logger.info("生产者结束运行...");
            }
        }
    }

    private static class Consumer {

        /**
         * logger
         */
        private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

        /**
         * BlockingQueue
         */
        private BlockingQueue<Integer> storage;

        /**
         * Constructor
         *
         * @param storage BlockingQueue<Integer>
         */
        public Consumer(BlockingQueue<Integer> storage) {
            this.storage = storage;
        }

        public boolean needMoreNums() {
            return Math.random() > 0.95;
        }

        public BlockingQueue<Integer> getStorage() {
            return storage;
        }

        public void setStorage(BlockingQueue<Integer> storage) {
            this.storage = storage;
        }
    }
}
