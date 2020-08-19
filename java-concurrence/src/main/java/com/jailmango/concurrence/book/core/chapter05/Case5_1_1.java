package com.jailmango.concurrence.book.core.chapter05;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 5.1.1 schedule(TimerTask task, Date time)方法 <br/>
 * 作用是在指定日期执行一次某任务 <br/>
 * TimerThread线程不销毁的原因: 创建Timer对象时启动了一个新的非守护线程 <br/>
 * (1) 若执行时间晚于当前时间 - 在未来执行
 * (2) 若执行时间早于当前时间 - 立即执行
 * @author he.gang33
 * @CreateDate 2020/8/17
 * @see com.jailmango.concurrence.book.core.chapter05
 * @since R9.0
 */
public class Case5_1_1 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case5_1_1.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        long now = System.currentTimeMillis();
        long scheduleTime = now + 5000;
        logger.info("Schedule Time: [{}]", scheduleTime);

        MyTask task = new MyTask();
        Timer timer = new Timer();
        Thread.sleep(1000);
        timer.schedule(task, new Date(scheduleTime));
        Thread.sleep(15000);
        timer.cancel();
        Thread.sleep(Integer.MAX_VALUE);
    }

    private static class MyTask extends TimerTask {

        @Override
        public void run() {
            logger.info("执行TimerTask ing...");
            try {
                Thread.sleep(5000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
