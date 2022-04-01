package com.jailmango.concurrence.book.core.chapter05;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 5.15.10 验证scheduleAtFixedRate()具备追赶执行性 <br/>
 * 若计划执行时间早于当前时间，则会将之前没有执行的任务追加执行。<br/>
 * 将两个时间段内的时间锁对应的Task任务被"弥补"地执行，<br/>
 * 也就是在指定时间段内运行次数必须运行完整，就是Task任务的追赶特性。
 *
 * @author jailmango
 * @CreateDate 2020/8/17
 * @see com.jailmango.concurrence.book.core.chapter05
 * @since R9.0
 */
public class Case5_1_5_10 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case5_1_5_10.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        MyTask task = new MyTask();

        long now = System.currentTimeMillis();
        logger.info("当前时间: [{}]", now);
        long runTime = now - 10000;
        logger.info("计划执行时间: [{}]", runTime);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(task, new Date(runTime), 2000);
    }

    private static class MyTask extends TimerTask {

        @Override
        public void run() {
            logger.info("[{}] -> start...", System.currentTimeMillis());
            logger.info("[{}] -> end...", System.currentTimeMillis());
            logger.info("-------------------");
        }
    }
}
