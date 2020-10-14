package com.jailmango.concurrence.book.core.chapter05;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 5.1.5.7 测试scheduleAtFixedRate()方法任务延时——Date类型 <br/>
 * 在延时的情况下，如果任务被延时执行，则下一次执行任务的开始时间是参考上一次任务的实际结束时间来开始的 <br/>
 *
 * @author he.gang33
 * @CreateDate 2020/8/17
 * @see com.jailmango.concurrence.book.core.chapter05
 * @since R9.0
 */
public class Case5_1_5_7 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case5_1_5_7.class);

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

        timer.scheduleAtFixedRate(task, new Date(now), 2000);
    }

    private static class MyTask extends TimerTask {

        @Override
        public void run() {
            try {
                logger.info("[{}] -> start...", System.currentTimeMillis());
                Thread.sleep(4500);
                logger.info("[{}] -> end...", System.currentTimeMillis());
                logger.info("-------------------");
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
