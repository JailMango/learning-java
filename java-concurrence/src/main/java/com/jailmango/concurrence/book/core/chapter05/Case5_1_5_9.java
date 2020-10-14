package com.jailmango.concurrence.book.core.chapter05;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 5.1.5.9 验证schedule()方法不具备追赶执行性 <br/>
 * 计划执行时间早于实际执行时间，且中间的任务被取消，不被执行 <br/>
 * 这说明不具备追赶执行性
 *
 * @author he.gang33
 * @CreateDate 2020/8/17
 * @see com.jailmango.concurrence.book.core.chapter05
 * @since R9.0
 */
public class Case5_1_5_9 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case5_1_5_9.class);

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
        timer.schedule(task, new Date(runTime), 2000);
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
