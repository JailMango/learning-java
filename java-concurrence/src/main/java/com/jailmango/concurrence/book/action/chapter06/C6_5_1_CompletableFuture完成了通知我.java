package com.jailmango.concurrence.book.action.chapter06;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import lombok.extern.slf4j.Slf4j;

/**
 * C6_5_1_CompletableFuture完成了通知我
 *
 * @author he.gang33
 * @CreateDate 2020/11/10
 * @see com.jailmango.concurrence.book.action.chapter06
 * @since R9.0
 */
@Slf4j
public class C6_5_1_CompletableFuture完成了通知我 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        final CompletableFuture<Integer> completableFuture = new CompletableFuture<>();
        new Thread(new AskThread(completableFuture)).start();
        Thread.sleep(4000);

        completableFuture.complete(50);
    }

    private static class AskThread implements Runnable {

        CompletableFuture<Integer> completableFuture = null;

        public AskThread(CompletableFuture<Integer> completableFuture) {
            this.completableFuture = completableFuture;
        }

        @Override
        public void run() {
            int myRe = 0;

            try {
                myRe = completableFuture.get() * completableFuture.get();

            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            catch (ExecutionException e) {
                e.printStackTrace();
            }

            log.info("result = {}", myRe);
        }
    }
}
