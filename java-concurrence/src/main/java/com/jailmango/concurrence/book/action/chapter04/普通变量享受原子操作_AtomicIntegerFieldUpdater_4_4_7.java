package com.jailmango.concurrence.book.action.chapter04;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

import lombok.extern.slf4j.Slf4j;

/**
 * 普通变量享受原子操作_AtomicIntegerFieldUpdater_4_4_7
 *
 * @author jailmango
 * @CreateDate 2020/10/12
 * @see com.jailmango.concurrence.book.action.chapter04
 * @since R9.0
 */
@Slf4j
public class 普通变量享受原子操作_AtomicIntegerFieldUpdater_4_4_7 {

    private static class Candidate {

        int id;

        volatile int score;
    }

    static final AtomicIntegerFieldUpdater<Candidate> scoreUpdater = AtomicIntegerFieldUpdater
        .newUpdater(Candidate.class, "score");

    static AtomicInteger allScore = new AtomicInteger(0);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        final Candidate candidate = new Candidate();
        Thread[] threads = new Thread[10000];

        for (int i = 0; i < 10000; i++) {
            threads[i] = new Thread(() -> {
                if (Math.random() > 0.4) {
                    scoreUpdater.incrementAndGet(candidate);
                    allScore.incrementAndGet();
                }
            });
            threads[i].start();
        }

        for (int i = 0; i < 10000; i++) {
            threads[i].join();
        }

        log.info("score = {}", candidate.score);
        log.info("all score = {}", allScore.get());
    }
}
