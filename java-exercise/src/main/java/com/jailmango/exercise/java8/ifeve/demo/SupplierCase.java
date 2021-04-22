package com.jailmango.exercise.java8.ifeve.demo;

import java.util.function.Supplier;

import lombok.extern.slf4j.Slf4j;

/**
 * SupplierCase
 *
 * @author gang.he2
 * @see com.jailmango.exercise.java8.ifeve.demo
 */
@Slf4j
public class SupplierCase {

    private static int count = 0;

    private static volatile boolean terminate = false;

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {

        while (judge(count)) {
            log.info("执行了{}次", ++count);
        }
        // SharedData data = new SharedData();
        //
        // Thread worker = new Thread(new Worker(data));
        // Thread operator = new Thread(new Operator(data));
        //
        // worker.start();
        // operator.start();
    }

    private static boolean judge(int count) {
        log.info("判断");
        return count < 100;
    }

    private static Supplier<Boolean> bizTask() {
        return () -> {
            try {
                Thread.sleep(300);
            }
            catch (InterruptedException e) {
                log.info("捕获异常");
            }
            log.info("执行了{}次", ++count);
            return Boolean.TRUE;
        };
    }

    private static Supplier<Boolean> judge(SharedData data) {
        return () -> {
            log.info("判断");
            return data.getTerminate();
        };
    }

    private static class Worker implements Runnable {

        private SharedData data;

        public Worker(SharedData data) {
            this.data = data;
        }

        @Override
        public void run() {
            InfiniteLoopUtil.doBiz(bizTask(), judge(data));
        }
    }

    private static class Operator implements Runnable {

        private SharedData data;

        public Operator(SharedData data) {
            this.data = data;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {
                    log.info("捕获异常");
                }
            }

            data.setTerminate(Boolean.FALSE);
        }
    }

    private static class SharedData {

        private volatile Boolean terminate = Boolean.TRUE;

        public Boolean getTerminate() {
            return terminate;
        }

        public void setTerminate(Boolean terminate) {
            this.terminate = terminate;
        }
    }

}
