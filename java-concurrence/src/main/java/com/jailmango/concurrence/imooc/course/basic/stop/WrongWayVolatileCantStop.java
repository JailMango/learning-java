package com.jailmango.concurrence.imooc.course.basic.stop;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * WrongWayVolatileCantStop <br/>
 * Chapter5-11 <br/>
 * 错误方法：演示用volatile的局限性 - part2 <br/>
 * 此例中，生产者的生产速度很快，消费者消费速度慢。<br/>
 * 所以阻塞队列满了以后，生产者会阻塞，等待消费者进一步消费
 *
 * @author he.gang33
 * @CreateDate 2020/4/19
 * @see com.jailmango.concurrence.imooc.course.basic.stop
 * @since R9.0
 */
public class WrongWayVolatileCantStop {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(WrongWayVolatileCantStop.class);

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
        producer.canceled = true;
    }

}

class Producer implements Runnable {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    /**
     * Canceled
     */
    public volatile boolean canceled = false;

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
            while (!canceled && num <= 100000) {
                if (num % 100 == 0) {
                    logger.info("{}是100的倍数...", num);
                    storage.put(num);
                }
                num++;
                Thread.sleep(10);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer {

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
        if (Math.random() > 0.95) {
            return false;
        }
        else {
            return true;
        }
    }

    public BlockingQueue<Integer> getStorage() {
        return storage;
    }

    public void setStorage(BlockingQueue<Integer> storage) {
        this.storage = storage;
    }
}