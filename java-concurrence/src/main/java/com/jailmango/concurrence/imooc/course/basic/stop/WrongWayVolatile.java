package com.jailmango.concurrence.imooc.course.basic.stop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * WrongWayVolatile <br/>
 * Chapter5-11 <br/>
 * 错误方法：演示用volatile的局限性 - part1 看似可行
 * 
 * @author jailmango
 * @CreateDate 2020/4/19
 * @see com.jailmango.concurrence.imooc.course.basic.stop
 * @since R9.0
 */
public class WrongWayVolatile implements Runnable {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(WrongWayVolatile.class);

    /**
     * canceled
     */
    private volatile boolean canceled = false;

    @Override
    public void run() {
        int num = 0;

        try {
            while (!canceled && num <= 100000) {
                if (num % 100 == 0) {
                    logger.info("{}是100的倍数...", num);
                }
                num++;
                Thread.sleep(1);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WrongWayVolatile runnable = new WrongWayVolatile();
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(2000);
        runnable.canceled = true;
    }
}
