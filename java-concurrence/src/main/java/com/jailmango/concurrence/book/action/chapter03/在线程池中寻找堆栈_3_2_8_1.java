package com.jailmango.concurrence.book.action.chapter03;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

/**
 * 在线程池中寻找堆栈_3_2_8
 *
 * @author he.gang33
 * @CreateDate 2020/10/9
 * @see com.jailmango.concurrence.book.action.chapter03
 * @since R9.0
 */
@Slf4j
public class 在线程池中寻找堆栈_3_2_8_1 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>());

        for (int i = 0; i < 5; i++) {
            Future future = executorService.submit(new MyTask(100, i));
            try {
                future.get();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            catch (ExecutionException e) {
                e.printStackTrace();
            }
            // executorService.execute(new MyTask(100, i));
        }
    }

    private static class MyTask implements Runnable {

        int a, b;

        public MyTask(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            log.info("{} / {} = {}", a, b, a / b);
        }
    }
}
