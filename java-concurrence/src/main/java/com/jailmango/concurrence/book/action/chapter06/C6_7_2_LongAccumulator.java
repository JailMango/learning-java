package com.jailmango.concurrence.book.action.chapter06;

import java.util.Random;
import java.util.concurrent.atomic.LongAccumulator;

import lombok.extern.slf4j.Slf4j;

/**
 * C6_7_2_LongAccumulator
 *
 * @author he.gang33
 * @CreateDate 2020/11/12
 * @see com.jailmango.concurrence.book.action.chapter06
 * @since R9.0
 */
@Slf4j
public class C6_7_2_LongAccumulator {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        LongAccumulator longAccumulator = new LongAccumulator(Long::max, Long.MIN_VALUE);
        Thread[] threads = new Thread[40];
        for (int i = 0; i < 40; i++) {
            threads[i] = new Thread(() -> {
                Random random = new Random();
                long value = random.nextLong();
                longAccumulator.accumulate(value);
            });
            threads[i].start();
        }

        for (int i = 0; i < 40; i++) {
            threads[i].join();
        }

        log.info("Max Value = {}", longAccumulator.longValue());
    }
}
