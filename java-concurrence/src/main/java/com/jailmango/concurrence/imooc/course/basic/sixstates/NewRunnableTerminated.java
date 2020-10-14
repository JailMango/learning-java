package com.jailmango.concurrence.imooc.course.basic.sixstates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * NewRunnableTerminated <br/>
 * 展示线程的NEW、RUNNABLE、TERMINATED状态。<br/>
 * 即使是正在运行，也是RUNNABLE状态，而不是RUNNING。
 *
 * @author he.gang33
 * @CreateDate 2020/4/29
 * @see com.jailmango.concurrence.imooc.course.basic.sixstates
 * @since R9.0
 */
public class NewRunnableTerminated implements Runnable {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(NewRunnableTerminated.class);

    public static void main(String[] args) {
        Thread thread = new Thread(new NewRunnableTerminated());
        logger.info("State: [{}]", thread.getState());

        thread.start();
        logger.info("State: [{}]", thread.getState());

        try {
            Thread.sleep(10);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        logger.info("State: [{}]", thread.getState());

        try {
            Thread.sleep(100);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        logger.info("State: [{}]", thread.getState());
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            logger.info("{}", i);
        }
    }
}
