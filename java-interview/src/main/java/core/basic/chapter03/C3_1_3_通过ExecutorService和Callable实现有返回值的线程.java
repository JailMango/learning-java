package core.basic.chapter03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import lombok.extern.slf4j.Slf4j;

/**
 * C3_1_3_通过ExecutorService和Callable实现有返回值的线程
 *
 * @author he.gang33
 * @CreateDate 2020/11/17
 * @see core.basic.chapter03
 * @since R9.0
 */
@Slf4j
public class C3_1_3_通过ExecutorService和Callable实现有返回值的线程 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        List<Future> futures = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Callable callable = new MyCallable("" + i);
            Future future = pool.submit(callable);

            log.info("submit a callable thread...");

            futures.add(future);
        }

        pool.shutdown();

        for (Future future : futures) {
            log.info("Getting result...");
            log.info("Result = {}", future.get());
        }
    }

    private static class MyCallable implements Callable<String> {

        private String name;

        public MyCallable(String name) {
            this.name = name;
        }

        @Override
        public String call() throws Exception {
            Thread.sleep(500);
            log.info("doing...");
            return this.name;
        }
    }
}
