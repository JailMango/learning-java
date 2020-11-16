package com.jailmango.concurrence.book.action.chapter05;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import lombok.extern.slf4j.Slf4j;

/**
 * C5_3_JDK_Future模式
 *
 * @author he.gang33
 * @CreateDate 2020/10/26
 * @see com.jailmango.concurrence.book.action.chapter05
 * @since R9.0
 */
@Slf4j
public class C5_5_3_JDK_Future模式 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(new RealData("x"));
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(futureTask);

        log.info("请求完毕...");
        log.info("结果[{}]", futureTask.get());
        executorService.shutdownNow();
        log.info("结束...");
    }

    private static class RealData implements Callable<String> {

        private String value;

        public RealData(String value) {
            this.value = value;
        }

        @Override
        public String call() throws Exception {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 10; i++) {
                sb.append(value);
                Thread.sleep(200);
            }
            return sb.toString();
        }
    }
}
