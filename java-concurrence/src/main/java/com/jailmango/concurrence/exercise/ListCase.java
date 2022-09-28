package com.jailmango.concurrence.exercise;

import com.google.common.collect.Lists;
import com.google.common.collect.Queues;

import java.time.ZoneId;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ListCase
 *
 * @author hegang1
 * @CreateDate 2022/7/19
 * @see com.jailmango.concurrence.exercise
 */
public class ListCase {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        ZoneId id = TimeZone.getDefault().toZoneId();
        List<Integer> list = Lists.newArrayList();

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(4, 8, 1000L, TimeUnit.MILLISECONDS, Queues.newArrayBlockingQueue(1000));

        for (int i = 0; i < 1000; i++) {
            poolExecutor.execute(() -> list.add(ThreadLocalRandom.current().nextInt(), 100));
        }


        Thread.sleep(10 * 1000);

        System.out.println(list.size());
    }



}
