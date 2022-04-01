package com.jailmango.concurrence.book.action.chapter06;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import lombok.extern.slf4j.Slf4j;

/**
 * C6_5_4_CompletableFuture中的异常处理
 *
 * @author jailmango
 * @CreateDate 2020/11/11
 * @see com.jailmango.concurrence.book.action.chapter06
 * @since R9.0
 */
@Slf4j
public class C6_5_4_CompletableFuture中的异常处理 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() -> cal(50))
            .exceptionally(throwable -> {
                log.info("deal exception...");
                return 0;
            }).thenAccept(unused -> log.info("Result = {}", unused));
        completableFuture.get();

        log.info("end...");
    }

    private static Integer cal(Integer para) {
        return para / 0;
    }
}
