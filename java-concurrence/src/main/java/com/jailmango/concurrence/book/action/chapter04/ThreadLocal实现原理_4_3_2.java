package com.jailmango.concurrence.book.action.chapter04;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lombok.extern.slf4j.Slf4j;

/**
 * ThreadLocal实现原理_4_3_2
 *
 * @author jailmango
 * @CreateDate 2020/10/12
 * @see com.jailmango.concurrence.book.action.chapter04
 * @since R9.0
 */
@Slf4j
public class ThreadLocal实现原理_4_3_2 {

    static volatile ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected void finalize() throws Throwable {
            log.info("ThreadLocal({}) is gc...", this.toString());
//            super.finalize();
        }
    };

    static volatile CountDownLatch countDownLatch = new CountDownLatch(10000);

    private static class ParseDate implements Runnable {

        int i = 0;

        public ParseDate(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            if (threadLocal.get() == null) {
                threadLocal.set(new SimpleDateFormat("YYYY-MM-dd HH:mm:ss"){
                    @Override
                    protected void finalize() throws Throwable {
                        log.info("ParseDate({}) is gc...", this.toString());
                    }
                });
            }

            try {
                threadLocal.get().parse("2020-01-01 00:00:" + i % 60);
            }
            catch (ParseException e) {
                e.printStackTrace();
            }
            finally {
                countDownLatch.countDown();
            }
        }
    }

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10000; i++) {
            executorService.execute(new ParseDate(i));
        }
        countDownLatch.await();

        log.info("misssion complete...");

        threadLocal = null;
        System.gc();
        log.info("first GC complete...");

        threadLocal = new ThreadLocal<>();
        countDownLatch = new CountDownLatch(10000);

        for (int i = 0; i < 10000; i++) {
            executorService.execute(new ParseDate(i));
        }
        countDownLatch.await();

        Thread.sleep(1000);
        System.gc();
        log.info("second GC complete...");

        executorService.shutdown();
    }
}
