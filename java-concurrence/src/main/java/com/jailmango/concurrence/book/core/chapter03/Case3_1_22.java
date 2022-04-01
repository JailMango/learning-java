package com.jailmango.concurrence.book.core.chapter03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case3_1_22 - 3.1.22 实现wait/notify的交叉备份
 *
 * @author jailmango
 * @CreateDate 2019-06-04
 * @see com.jailmango.concurrence.book.core.chapter03
 * @since R9.0
 */
public class Case3_1_22 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case3_1_22.class);

    public static void main(String[] args) {
        BackUpA[] backUpAPoll = new BackUpA[10];
        BackUpB[] backUpBPoll = new BackUpB[10];
        DBTools tools = new DBTools();

        for (int i = 0; i < 10; i++) {
            backUpAPoll[i] = new BackUpA("BackUp-A-" + i, tools);
            backUpBPoll[i] = new BackUpB("BackUp-B-" + i, tools);
        }

        for (int i = 0; i < 10; i++) {
            backUpAPoll[i].start();
            backUpBPoll[i].start();
        }
    }

    static class DBTools {

        private volatile boolean previousIsA = false;

        public synchronized void backUpA() {
            try {
                while (previousIsA) {
                    this.wait();
                }

                logger.info("★★★★★ [{}] back up A ★★★★★", Thread.currentThread().getName());
                Thread.sleep(500);
                this.previousIsA = true;
                notifyAll();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public synchronized void backUpB() {
            try {
                while (!previousIsA) {
                    this.wait();
                }

                logger.info("☆☆☆☆☆ [{}] back up B ☆☆☆☆☆", Thread.currentThread().getName());
                Thread.sleep(500);
                this.previousIsA = false;
                notifyAll();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    static class BackUpA extends Thread {

        private DBTools tools;

        public BackUpA(String name, DBTools tools) {
            super(name);
            this.tools = tools;
        }

        @Override
        public void run() {
            tools.backUpA();
        }
    }

    static class BackUpB extends Thread {

        private DBTools tools;

        public BackUpB(String name, DBTools tools) {
            super(name);
            this.tools = tools;
        }

        @Override
        public void run() {
            tools.backUpB();
        }
    }
}
