package com.jailmango.concurrence.book.action.chapter03;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

import lombok.extern.slf4j.Slf4j;

/**
 * 分而治之ForkJoin框架_3_2_9
 *
 * @author he.gang33
 * @CreateDate 2020/10/9
 * @see com.jailmango.concurrence.book.action.chapter03
 * @since R9.0
 */
@Slf4j
public class C3_2_9_分而治之ForkJoin框架 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask task = new CountTask(50L, 300L);
        ForkJoinTask<Long> result = forkJoinPool.submit(task);

        try {
            Long sum = result.get();
            log.info("sum = {}", sum);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (ExecutionException e) {
            e.printStackTrace();
        }

        log.info("end...");
    }

    private static class CountTask extends RecursiveTask<Long> {

        private static final int THRESHOLD = 100;

        private long start;

        private long end;

        public CountTask(long start, long end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            long sum = 0;
            boolean canCompute = (end - start) < THRESHOLD;

            if (canCompute) {
                for (long i = start; i <= end; i++) {
                    sum += i;
                }
            }
            else {
                // 分成100个任务
                long step = (end - start) / 4;
                ArrayList<CountTask> subTasks = new ArrayList<>();
                long pos = start;

                for (int i = 0; i < 10; i++) {
                    long lastOne = pos + step;

                    if (lastOne > end) {
                        lastOne = end;
                    }

                    CountTask subTask = new CountTask(pos, lastOne);
                    pos += step + 1;
                    subTasks.add(subTask);
                    subTask.fork();
                }

                for (CountTask task : subTasks) {
                    sum += task.join();
                }
            }

            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            return sum;
        }
    }
}
