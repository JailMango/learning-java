package com.jailmango.concurrence.book.action.chapter06;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import lombok.extern.slf4j.Slf4j;

/**
 * C6_5_3_流式调用
 *
 * @author jailmango
 * @CreateDate 2020/11/11
 * @see com.jailmango.concurrence.book.action.chapter06
 * @since R9.0
 */
@Slf4j
public class C6_5_3_流式调用 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() -> calc(50))
            .thenApply(integer -> integer * 10).thenApply(integer -> integer * 10)
            .thenAccept(integer -> log.info("Result = {}", integer));
        completableFuture.get();
        log.info("end...");
    }

    private static Integer calc(Integer para) {
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        return para * para;
    }
}
