package com.jailmango.concurrence.book.core.chapter05;

import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 5.1.5.6 测试scheduleAtFixedRate()方法任务不延时——long类型 <br/>
 * 在不延时的情况下，如果任务没有被延时执行，则第一次执行任务的时间是任务开始时间加上delay时间，<br/>
 * 接下来执行任务的时间是上一次任务的开始时间 + period <br/>
 * "不延时"是指执行任务的时间小于period间隔时间
 *
 * @author jailmango
 * @CreateDate 2020/8/17
 * @see com.jailmango.concurrence.book.core.chapter05
 * @since R9.0
 */
public class Case5_1_5_6 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case5_1_5_6.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        MyTask task = new MyTask();
        Timer timer = new Timer();

        long now = System.currentTimeMillis();
        logger.info("当前时间: [{}]", now);

        timer.scheduleAtFixedRate(task, 2000, 2000);
    }

    private static class MyTask extends TimerTask {

        @Override
        public void run() {
            try {
                logger.info("[{}] -> start...", System.currentTimeMillis());
                Thread.sleep(1300);
                logger.info("[{}] -> end...", System.currentTimeMillis());
                logger.info("-------------------");
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
