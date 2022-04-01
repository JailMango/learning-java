package com.jailmango.concurrence.exercise;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Pool
 *
 * @author jailmango
 * @see com.jailmango.concurrence.exercise
 */
@Slf4j
public class Pool {

    /**
     * main
     *
     * @param args
     *            String[]
     */
    public static void main(String[] args) {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(5);
        scheduler.setThreadNamePrefix("scheduler-");

        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < 20; i++) {
            FutureTask<Boolean> futureTask = new FutureTask<>(() -> {
                Thread.sleep(300);
                log.info("处理任务..");
                return true;
            });

            log.info("提交任务");
            service.schedule(futureTask, 1000, TimeUnit.MILLISECONDS);
        }
    }
}
