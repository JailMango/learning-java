package com.jailmango.concurrence.book.core.chapter05;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 5.1.2 Timer类中间隔执行Task任务的算法 <br/>
 * 将最后一个任务放入队列头，再执行队列头中的Task任务的run()方法，效果如下：<br/>
 * ABC -> CAB -> BCA
 *
 * @author jailmango
 * @CreateDate 2020/8/17
 * @see com.jailmango.concurrence.book.core.chapter05
 * @since R9.0
 */
public class Case5_1_2_3 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case5_1_2_3.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        long now = System.currentTimeMillis();
        long scheduleTime = now + 2000;
        logger.info("计划时间: [{}]", scheduleTime);

        MyTaskA ta = new MyTaskA();
        MyTaskB tb = new MyTaskB();
        MyTaskC tc = new MyTaskC();

        Timer timer = new Timer();
        timer.schedule(ta, new Date(scheduleTime), 4000);
        timer.schedule(tb, new Date(scheduleTime), 4000);
        timer.schedule(tc, new Date(scheduleTime), 4000);

        Thread.sleep(Integer.MAX_VALUE);
    }

    private static class MyTaskA extends TimerTask {

        @Override
        public void run() {
            logger.info("执行TimerTask-A...");
        }
    }

    private static class MyTaskB extends TimerTask {

        @Override
        public void run() {
            logger.info("执行TimerTask-B...");
        }
    }

    private static class MyTaskC extends TimerTask {

        @Override
        public void run() {
            logger.info("执行TimerTask-C...");
        }
    }
}
