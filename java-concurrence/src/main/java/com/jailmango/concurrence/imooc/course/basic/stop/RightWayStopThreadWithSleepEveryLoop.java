package com.jailmango.concurrence.imooc.course.basic.stop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * RightWayStopThreadWithSleepEveryLoop <br/>
 * Chapter5-4 <br/>
 * 每次循环都有sleep()或wait()等方法，那么不需要每次迭代都检查是否已中断
 *
 * @author he.gang33
 * @CreateDate 2020/4/15
 * @see com.jailmango.concurrence.imooc.course.basic.stop
 * @since R9.0
 */
public class RightWayStopThreadWithSleepEveryLoop {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(RightWayStopThreadWithSleepEveryLoop.class);

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            int num = 0;
            try {
                while (num <= 10000) {
                    if (num % 100 == 0) {
                        logger.info("{}是100的倍数...", num);
                    }
                    num++;
                    Thread.sleep(10);
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.info("end...");
        };

        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
    }
}
