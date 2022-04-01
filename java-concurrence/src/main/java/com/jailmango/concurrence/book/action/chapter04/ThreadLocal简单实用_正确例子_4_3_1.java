package com.jailmango.concurrence.book.action.chapter04;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lombok.extern.slf4j.Slf4j;

/**
 * ThreadLocal简单实用_4_3_1 因为SimpleDateFormat不是线程安全的，因此作为共享对象会出现问题。
 * 
 * @author jailmango
 * @CreateDate 2020/10/12
 * @see com.jailmango.concurrence.book.action.chapter04
 * @since R9.0
 */
@Slf4j
public class ThreadLocal简单实用_正确例子_4_3_1 {

    private static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<>();

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 1000; i++) {
            executorService.execute(new ParseDate(i));
        }
    }

    private static class ParseDate implements Runnable {

        private int i = 0;

        public ParseDate(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            if (threadLocal.get() == null) {
                threadLocal.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
            }

            try {
                Date date = threadLocal.get().parse("2020-01-01 00:00:" + i % 60);
                log.info("{} -> {}", i, date);
            }
            catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
