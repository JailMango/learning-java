package com.jailmango.concurrence.book.async.chapter02;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 2.2.1 - 显式使用线程池 <br/>
 * 向线程池提交Callable类型的任务，可获取其执行结果
 *
 * @author gang.he2
 * @see com.jailmango.concurrence.book.async.chapter02
 */
@Slf4j
public class Case2_2_2 {

    /**
     * main
     *
     * @param args
     *            String[]
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = new ThreadPoolExecutor(availableProcessors, availableProcessors * 2, 1, TimeUnit.MINUTES,
            new LinkedBlockingDeque<>(5), new ThreadPoolExecutor.CallerRunsPolicy());

        long start = System.currentTimeMillis();

        Future<String> resulta = executorService.submit(Case2_2_2::doSomethingA);
        Future<String> resultb = executorService.submit(Case2_2_2::doSomethingB);

        long end = System.currentTimeMillis();

        log.info("Cost -> {}ms", end - start);

        log.info("{}", resulta.get());
        log.info("{}", resultb.get());

        log.info("end");
    }

    private static String doSomethingA() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("do A...");

        return "result = A";
    }

    private static String doSomethingB() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("do B...");

        return "result = B";
    }
}
