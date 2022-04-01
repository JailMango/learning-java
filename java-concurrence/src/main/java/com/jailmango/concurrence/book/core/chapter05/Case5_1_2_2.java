package com.jailmango.concurrence.book.core.chapter05;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 5.1.2 schedule(TimerTask, Date firstTime, long period)方法 <br/>
 * TimerTask类中的cancel()方法，将TimerTask自身从任务队列中消除，其他任务不受影响 <br/>
 * Timer类中的cancel()方法，与TimerTask.cancel()方法不同，该方法是将任务队列中的任务全部清空
 * 
 * @author jailmango
 * @CreateDate 2020/8/17
 * @see com.jailmango.concurrence.book.core.chapter05
 * @since R9.0
 */
public class Case5_1_2_2 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case5_1_2_2.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        long now = System.currentTimeMillis();
        long scheduleTime = now + 2000;

        MyTaskA taskA = new MyTaskA();
        MyTaskB taskB = new MyTaskB();

        Timer timer = new Timer();
        timer.schedule(taskA, new Date(scheduleTime), 2000);
        timer.schedule(taskB, new Date(scheduleTime), 2000);

        Thread.sleep(20000);
        timer.cancel();
    }

    private static class MyTaskA extends TimerTask {

        @Override
        public void run() {
            logger.info("执行TimerTask-A...");

            try {
                Thread.sleep(500);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.cancel();
            logger.info("移除TimerTask-A...");
        }
    }

    private static class MyTaskB extends TimerTask {

        @Override
        public void run() {
            logger.info("执行TimerTask-B...");
        }
    }
}
