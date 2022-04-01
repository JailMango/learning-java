package com.jailmango.concurrence.book.action.chapter05;

import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.WorkHandler;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

/**
 * C5_4_2_使用Disruptor实现生产者消费者
 *
 * @author jailmango
 * @CreateDate 2020/10/22
 * @see com.jailmango.concurrence.book.action.chapter05
 * @since R9.0
 */
@Slf4j
public class C5_4_2_使用Disruptor实现生产者消费者 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        DataFactory dataFactory = new DataFactory();

        int bufferSize = 16;

        Disruptor<Data> disruptor = new Disruptor<>(dataFactory, bufferSize, executorService, ProducerType.MULTI,
            new BlockingWaitStrategy());
        disruptor.handleEventsWithWorkerPool(new Consumer(), new Consumer(), new Consumer(), new Consumer());
        disruptor.start();

        RingBuffer<Data> ringBuffer = disruptor.getRingBuffer();
        Producer producer = new Producer(ringBuffer);

        for (int i = 0; true; i++) {
            producer.pushData(i);
        }

    }

    private static class Producer {

        private final RingBuffer<Data> ringBuffer;

        public Producer(RingBuffer<Data> ringBuffer) {
            this.ringBuffer = ringBuffer;
        }

        public void pushData(int value) {
            long sequence = ringBuffer.next();
            Data event = null;
            try {
                event = ringBuffer.get(sequence);
                event.setValue(value);
            }
            finally {
                ringBuffer.publish(sequence);
                log.info("生产数据[{}]", event.getValue());
            }
        }

    }

    private static class Consumer implements WorkHandler<Data> {

        @Override
        public void onEvent(Data event) throws Exception {
            Thread.sleep(500);
            log.info("消费数据[{}]", event.getValue());
        }
    }

    private static class DataFactory implements EventFactory<Data> {

        @Override
        public Data newInstance() {
            return new Data();
        }
    }

    @lombok.Data
    @ToString
    private static class Data {

        private int value;
    }
}
