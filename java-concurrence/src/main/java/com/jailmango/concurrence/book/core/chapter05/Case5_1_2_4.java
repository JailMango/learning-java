package com.jailmango.concurrence.book.core.chapter05;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 5.1.2 Timer类中的cancel()方法的使用注意事项 <br/>
 * 调用Timer类中的cancel()方法有时不一定会停止计划任务，即计划任务正常执行 <br/>
 * 原因是Timer类中的cancel()方法，有时并没有正抢到queue锁，所以TimerTask类中的任务正常执行
 *
 * @author jailmango
 * @CreateDate 2020/8/17
 * @see com.jailmango.concurrence.book.core.chapter05
 * @since R9.0
 */
public class Case5_1_2_4 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case5_1_2_4.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        int i = 0;
        long now = System.currentTimeMillis();

        while (true) {
            i++;
            Timer timer = new Timer();
            MyTask task = new MyTask(i);
            timer.schedule(task, new Date(now));
            timer.cancel();
        }
    }

    private static class MyTask extends TimerTask {

        private int i;

        public MyTask(int i) {
            super();
            this.i = i;
        }

        @Override
        public void run() {
            logger.info("第[{}]次没有被cancel取消...", i);
        }
    }
}
