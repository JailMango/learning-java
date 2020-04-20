package com.jailmango.concurrence.imooc.course.basic.stop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * RightWayStopThreadWithoutSleep <br/>
 * Chapter5-3 <br/>
 * run()方法内没有sleep()或wait()方法时，停止线程
 * 
 * @author he.gang33
 * @CreateDate 2020/4/14
 * @see com.jailmango.concurrence.imooc.course.basic.stop
 * @since R9.0
 */
public class RightWayStopThreadWithoutSleep implements Runnable {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(RightWayStopThreadWithoutSleep.class);

    /**
     * main
     * 
     * @param args String[]
     * @throws InterruptedException InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadWithoutSleep());
        thread.start();
        Thread.sleep(10);
        thread.interrupt();
    }

    @Override
    public void run() {
        int num = 0;

        while (!Thread.currentThread().isInterrupted() && num <= Integer.MAX_VALUE / 2) {
            if (num % 10000 == 0) {
                logger.info("{}是10000的倍数...", num);
            }
            num++;
        }

        logger.info("end...");
    }
}
