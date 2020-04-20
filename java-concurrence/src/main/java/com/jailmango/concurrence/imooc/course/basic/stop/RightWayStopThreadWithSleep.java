package com.jailmango.concurrence.imooc.course.basic.stop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * RightWayStopThreadWithSleep <br/>
 * Chapter5-4 <br/>
 * run()方法内有sleep()或wait()方法时，停止线程
 * 
 * @author he.gang33
 * @CreateDate 2020/4/15
 * @see com.jailmango.concurrence.imooc.course.basic.stop
 * @since R9.0
 */
public class RightWayStopThreadWithSleep {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(RightWayStopThreadWithSleep.class);

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            int num = 0;
            try {
                while (!Thread.currentThread().isInterrupted() && num <= 300) {
                    if (num % 100 == 0) {
                        logger.info("{}是100的倍数...", num);
                    }
                    num++;
                }
                Thread.sleep(5000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

            logger.info("end...");
        };

        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
