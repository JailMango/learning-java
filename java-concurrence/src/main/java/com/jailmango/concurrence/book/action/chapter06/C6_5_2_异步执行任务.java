package com.jailmango.concurrence.book.action.chapter06;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import lombok.extern.slf4j.Slf4j;

/**
 * C6_5_2_异步执行任务
 *
 * @author he.gang33
 * @CreateDate 2020/11/10
 * @see com.jailmango.concurrence.book.action.chapter06
 * @since R9.0
 */
@Slf4j
public class C6_5_2_异步执行任务 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> calc(50));
        log.info("result = {}", completableFuture.get());
        log.info("end...");
    }

    private static Integer calc(Integer para) {
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        return para * para;
    }
}
