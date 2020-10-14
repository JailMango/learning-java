package com.jailmango.concurrence.book.action.chapter03;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import lombok.extern.slf4j.Slf4j;

/**
 * 循环栅栏CyclicBarrier_3_1_6
 *
 * @author he.gang33
 * @CreateDate 2020/10/7
 * @see com.jailmango.concurrence.book.action.chapter03
 * @since R9.0
 */
@Slf4j
public class 循环栅栏CyclicBarrier_3_1_6 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        final int N = 10;
        Thread[] allSoldiers = new Thread[30];
        boolean flag = false;

        CyclicBarrier cyclicBarrier = new CyclicBarrier(N, new BarrierRun(flag, N));
        log.info("集合队伍...");

        for (int i = 0; i < 30; i++) {
            log.info("士兵{}报道", i);
            allSoldiers[i] = new Thread(new Soldier("士兵" + i, cyclicBarrier));
            if (i == 5) {
                allSoldiers[0].interrupt();
            }
            allSoldiers[i].start();
        }

    }

    private static class Soldier implements Runnable {

        private String soldier;

        private final CyclicBarrier cyclicBarrier;

        public Soldier(String soldier, CyclicBarrier cyclicBarrier) {
            this.soldier = soldier;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                cyclicBarrier.await();
                doWork();
                cyclicBarrier.await();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        public void doWork() {
            try {
                Thread.sleep(1500);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

            log.info("{}完成任务", this.soldier);
        }
    }

    private static class BarrierRun implements Runnable {

        boolean flag;

        int N;

        public BarrierRun(boolean flag, int n) {
            this.flag = flag;
            N = n;
        }

        @Override
        public void run() {
            if (flag) {
                log.info("士兵{}个，完成任务", N);
            }
            else {
                log.info("士兵{}个，集合完毕", N);
                flag = true;
            }
        }
    }
}
