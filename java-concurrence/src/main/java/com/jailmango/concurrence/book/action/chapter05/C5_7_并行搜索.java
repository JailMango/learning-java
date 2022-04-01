package com.jailmango.concurrence.book.action.chapter05;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

import lombok.extern.slf4j.Slf4j;

/**
 * C5_7_并行搜索
 *
 * @author jailmango
 * @CreateDate 2020/10/27
 * @see com.jailmango.concurrence.book.action.chapter05
 * @since R9.0
 */
@Slf4j
public class C5_7_并行搜索 {

    static final int TOTAL = 15;

    static final int THREAD_NUMS = 2;

    static int[] array;

    static ExecutorService pool = Executors.newCachedThreadPool();

    static AtomicInteger result = new AtomicInteger(-1);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        array = new int[TOTAL];

        for (int i = 0; i < TOTAL; i++) {
            array[i] = i;
        }

        log.info("结果[{}]", pSearch(13));
    }

    public static int pSearch(int searchValue) throws ExecutionException, InterruptedException {
        int subArraySize = array.length / THREAD_NUMS + 1;
        List<Future<Integer>> futures = new ArrayList<>();

        for (int begin = 0; begin < array.length; begin++) {
            int end = begin + subArraySize;

            if (end >= array.length) {
                end = array.length;
            }

            futures.add(pool.submit(new SearchTask(begin, end, searchValue)));
        }

        for (Future<Integer> future : futures) {
            if (future.get() >= 0) {
                return future.get();
            }
        }

        return -1;
    }

    public static int search(int beginPos, int endPos, int searchValue) {
        for (int i = beginPos; i < endPos; i++) {
            if (result.get() >= 0) {
                return result.get();
            }

            if (array[i] == searchValue) {
                if (result.compareAndSet(-1, i)) {
                    return result.get();
                }

                return i;
            }
        }

        return -1;
    }

    private static class SearchTask implements Callable<Integer> {

        int beginPos;

        int endPos;

        int searchValue;

        public SearchTask(int beginPos, int endPos, int searchValue) {
            this.beginPos = beginPos;
            this.endPos = endPos;
            this.searchValue = searchValue;
        }

        @Override
        public Integer call() throws Exception {
            return search(beginPos, endPos, searchValue);
        }
    }

}
