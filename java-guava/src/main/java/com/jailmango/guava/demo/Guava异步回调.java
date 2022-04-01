package com.jailmango.guava.demo;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

/**
 * Guava异步回调
 *
 * @author jailmango
 * @CreateDate 2021/10/11
 * @see com.jailmango.guava.demo
 */
@Slf4j
public class Guava异步回调 {

    private static final int SLEEP_GAP = 500;

    /**
     * main
     *
     * @param args
     *            String[]
     */
    public static void main(String[] args) {

    }

    private static class HotWater implements Callable<Boolean> {

        @Override
        public Boolean call() {
            try {
                Thread.sleep(SLEEP_GAP);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return Boolean.FALSE;
            }

            log.info("HotWaterThread done...");
            return Boolean.TRUE;
        }
    }

    private static class Wash implements Callable<Boolean> {

        @Override
        public Boolean call() {
            try {
                Thread.sleep(SLEEP_GAP);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return Boolean.FALSE;
            }

            log.info("WashThread done...");
            return Boolean.TRUE;
        }
    }
}
