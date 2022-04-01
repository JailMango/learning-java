package com.jailmango.concurrence.imooc.course.basic.create.wrongways;

import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TimmerTask <br/>
 * 用定时器创建线程
 * 
 * @author jailmango
 * @CreateDate 2020/4/13
 * @see com.jailmango.concurrence.imooc.course.basic.create.wrongways
 * @since R9.0
 */
public class TimerCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(TimerCase.class);

    /**
     * main
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                logger.info("{} do timer task...", Thread.currentThread().getName());
            }
        }, 1000, 1000);
    }
}
