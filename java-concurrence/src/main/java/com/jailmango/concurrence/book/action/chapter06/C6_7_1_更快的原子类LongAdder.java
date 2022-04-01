package com.jailmango.concurrence.book.action.chapter06;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

import lombok.extern.slf4j.Slf4j;

/**
 * C6_7_1_更快的原子类LongAdder
 *
 * @author jailmango
 * @CreateDate 2020/11/12
 * @see com.jailmango.concurrence.book.action.chapter06
 * @since R9.0
 */
@Slf4j
public class C6_7_1_更快的原子类LongAdder {

    private static final int MAX_THREADS = 3;

    private static final int TASK_COUNT = 3;

    private static final int TARGET_COUNT = 10000000;

    private long count = 0;

    private LongAdder laccount = new LongAdder();

    private AtomicLong acount = new AtomicLong(0L);

    private CountDownLatch cdlSync = new CountDownLatch(TASK_COUNT);

    private CountDownLatch cdlAtomic = new CountDownLatch(TASK_COUNT);

    private CountDownLatch cdlAdder = new CountDownLatch(TASK_COUNT);

    private class LongAdderDemo {
        protected synchronized long inc() {
            return ++count;
        }

        protected synchronized long getCount() {
            return count;
        }
    }

    private class SyncThread implements Runnable {

        protected String name;

        protected long startTime;

        private LongAdderDemo out;

        public SyncThread(long startTime, LongAdderDemo out) {
            this.startTime = startTime;
            this.out = out;
        }

        @Override
        public void run() {
            long v = out.getCount();
            while (v < TARGET_COUNT) {
                v = out.inc();
            }

            long endTime = System.currentTimeMillis();
            log.info("SyncThread cost {}ms", endTime - startTime);
            cdlSync.countDown();
        }
    }

    public void testSync() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(MAX_THREADS);
        LongAdderDemo out = new LongAdderDemo();
        long startTime = System.currentTimeMillis();
        SyncThread st = new SyncThread(startTime, out);
        for (int i = 0; i < TASK_COUNT; i++) {
            executorService.submit(st);
        }
        cdlSync.await();
        executorService.shutdown();
    }

}
