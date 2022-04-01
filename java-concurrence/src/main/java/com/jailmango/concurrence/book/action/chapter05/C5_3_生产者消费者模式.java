package com.jailmango.concurrence.book.action.chapter05;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * C5_3_生产者消费者模式
 *
 * @author jailmango
 * @CreateDate 2020/10/21
 * @see com.jailmango.concurrence.book.action.chapter05
 * @since R9.0
 */
@Slf4j
public class C5_3_生产者消费者模式 {

    private static final Long PRODUCE_SLEEP_TIME = 300L;

    private static final Long CONSUME_SLEEP_TIME = 500L;

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Data> queue = new ArrayBlockingQueue<>(10);

        Producer p1 = new Producer(queue);
        Producer p2 = new Producer(queue);
        Producer p3 = new Producer(queue);
        Consumer c1 = new Consumer(queue);
        Consumer c2 = new Consumer(queue);
        Consumer c3 = new Consumer(queue);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(p1);
        executorService.execute(p2);
        executorService.execute(p3);
        executorService.execute(c1);
        executorService.execute(c2);
        executorService.execute(c3);

        Thread.sleep(2000);
        p1.stop();
        p2.stop();
        p3.stop();

        executorService.shutdown();
        executorService.awaitTermination(2000, TimeUnit.MILLISECONDS);
    }

    private static class Producer implements Runnable {

        private static AtomicInteger count = new AtomicInteger();

        private volatile boolean isRunning = true;

        private BlockingQueue<Data> queue;

        public Producer(BlockingQueue<Data> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            log.info("{}启动...", Thread.currentThread().getName());

            Data data = null;
            Random random = new Random();

            try {
                while (isRunning) {
                    data = new Data(count.incrementAndGet());
                    log.info("生产数据[{}]...", data.getData());
                    Thread.sleep(PRODUCE_SLEEP_TIME);

                    queue.put(data);
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }

            log.info("{}停止...", Thread.currentThread().getName());
        }

        public void stop() {
            this.isRunning = false;
        }
    }

    private static class Consumer implements Runnable {

        private volatile boolean isRunning = true;

        private BlockingQueue<Data> queue;

        public Consumer(BlockingQueue<Data> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            log.info("{}启动...", Thread.currentThread().getName());

            try {
                while (isRunning) {
                    Thread.sleep(CONSUME_SLEEP_TIME);
                    log.info("消费数据[{}]", queue.take());
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }

        public void stop() {
            this.isRunning = false;
        }
    }

    @AllArgsConstructor
    @Getter
    @ToString
    private static final class Data {

        private final int data;
    }
}
