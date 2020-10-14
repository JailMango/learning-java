package com.jailmango.concurrence.book.core.chapter05;

import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 5.1.3 schedule(TimerTask task, long delay)方法的测试 <br/>
 * 作用是以执行该方法的当前时间作为参考时间，在此时间基础上延迟指定的毫秒数后执行一次TimerTask任务 <br/>
 * schedule(TimerTask task, long delay, long period)作用大致相同，只是会周期性执行
 * @author he.gang33
 * @CreateDate 2020/8/17
 * @see com.jailmango.concurrence.book.core.chapter05
 * @since R9.0
 */
public class Case5_1_3 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case5_1_3.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        MyTask task = new MyTask();
        Timer timer = new Timer();
        logger.info("当前时间: [{}]", System.currentTimeMillis());
        timer.schedule(task, 2000);

        Thread.sleep(3000);
        timer.cancel();
        Thread.sleep(Integer.MAX_VALUE);
    }

    private static class MyTask extends TimerTask {

        @Override
        public void run() {
            logger.info("当前时间: [{}]", System.currentTimeMillis());
            logger.info("执行TimerTask...");
        }
    }
}
