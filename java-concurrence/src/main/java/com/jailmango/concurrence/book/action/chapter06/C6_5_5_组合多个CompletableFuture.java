package com.jailmango.concurrence.book.action.chapter06;

import static com.jailmango.concurrence.book.action.chapter02.Case2_2_6_1.i;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import lombok.extern.slf4j.Slf4j;

/**
 * C6_5_5_组合多个CompletableFuture
 *
 * @author he.gang33
 * @CreateDate 2020/11/11
 * @see com.jailmango.concurrence.book.action.chapter06
 * @since R9.0
 */
@Slf4j
public class C6_5_5_组合多个CompletableFuture {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() -> calc(50))
            .thenCompose(integer -> CompletableFuture.supplyAsync(() -> calc(i)))
            .thenAccept(integer -> log.info("Result = {}", integer));
        completableFuture.get();

        log.info("===================");

        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> calc(50));
        CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(() -> calc(25));
        CompletableFuture<Void> cfUn = cf1.thenCombine(cf2, (integer, integer2) -> integer + integer2)
            .thenAccept(unused -> log.info("Result = {}", unused));
        cfUn.get();

        log.info("end...");
    }

    private static Integer calc(Integer para) {
        return para / 2;
    }
}
