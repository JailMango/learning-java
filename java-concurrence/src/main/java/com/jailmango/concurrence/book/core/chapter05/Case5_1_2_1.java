package com.jailmango.concurrence.book.core.chapter05;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 5.1.2 schedule(TimerTask, Date firstTime, long period)方法 <br/>
 * 
 * @author he.gang33
 * @CreateDate 2020/8/17
 * @see com.jailmango.concurrence.book.core.chapter05
 * @since R9.0
 */
public class Case5_1_2_1 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case5_1_2_1.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        long now = System.currentTimeMillis();
        long scheduleTime = now + 2000;

        MyTask task = new MyTask();
        Timer timer = new Timer();
        timer.schedule(task, new Date(scheduleTime), 1000);
    }

    private static class MyTask extends TimerTask {

        @Override
        public void run() {
            logger.info("执行TimerTask...");
        }
    }
}
