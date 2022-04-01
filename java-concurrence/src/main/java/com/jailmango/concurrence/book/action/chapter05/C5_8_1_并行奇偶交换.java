package com.jailmango.concurrence.book.action.chapter05;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lombok.extern.slf4j.Slf4j;

/**
 * C5_8_1_并行奇偶交换
 *
 * @author jailmango
 * @CreateDate 2020/10/28
 * @see com.jailmango.concurrence.book.action.chapter05
 * @since R9.0
 */
@Slf4j
public class C5_8_1_并行奇偶交换 {

    static int[] arr = {
        5, 52, 6, 3, 4, 10, 8, 100, 35, 78, 64, 31, 77, 90, 45, 53, 89, 78, 1
    };

    static ExecutorService pool = Executors.newCachedThreadPool();

    static int exchangeFlag = 1;

    static synchronized void setExchangeFlag(int value) {
        exchangeFlag = value;
    }

    static synchronized int getExchangeFlag() {
        return exchangeFlag;
    }

    private static class OddEvenSortTask implements Runnable {

        int i;

        CountDownLatch countDownLatch;

        public OddEvenSortTask(int i, CountDownLatch countDownLatch) {
            this.i = i;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            if (arr[i] > arr[i + 1]) {
                int tmp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = tmp;

                setExchangeFlag(1);
            }

            this.countDownLatch.countDown();
        }
    }

    private static void pOddEvenSort(int[] arr) throws InterruptedException {
        int start = 0;

        while (getExchangeFlag() == 1 || start == 1) {
            setExchangeFlag(0);
            CountDownLatch latch = new CountDownLatch(arr.length / 2 - (arr.length%2==0?start:0));

            for (int i = start; i < arr.length - 1; i += 2) {
                pool.submit(new OddEvenSortTask(i, latch));
            }

            latch.await();

            if (start == 0) {
                start = 1;
            }
            else {
                start = 0;
            }
        }
    }

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        pOddEvenSort(arr);
        pool.shutdownNow();
        log.info("{}", Arrays.toString(arr));
    }
}
