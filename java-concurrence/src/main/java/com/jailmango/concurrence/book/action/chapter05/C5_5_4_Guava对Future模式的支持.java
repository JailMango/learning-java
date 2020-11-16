package com.jailmango.concurrence.book.action.chapter05;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

import lombok.extern.slf4j.Slf4j;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

/**
 * C5_5_4_Guava对Future模式的支持
 *
 * @author he.gang33
 * @CreateDate 2020/10/26
 * @see com.jailmango.concurrence.book.action.chapter05
 * @since R9.0
 */
@Slf4j
public class C5_5_4_Guava对Future模式的支持 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        ListeningExecutorService listeningExecutorService = MoreExecutors
            .listeningDecorator(Executors.newFixedThreadPool(10));
        ListenableFuture<String> task = listeningExecutorService.submit(new RealData("x"));

        task.addListener(() -> {
            log.info("异步处理...");
            try {
                log.info("结果[{}]", task.get());
                log.info("异步处理成功...");
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            catch (ExecutionException e) {
                e.printStackTrace();
            }
        }, MoreExecutors.directExecutor());

        log.info("主任务结束...");
        Thread.sleep(3000);
        listeningExecutorService.shutdownNow();
        log.info("关闭...");
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
