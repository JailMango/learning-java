package com.jailmango.concurrence.imooc.course.basic.stop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * RightWayInterrupted <br/>
 * Thread.interrupted()的目标对象是当前线程，而不管来自于哪个对象
 * 
 * @author jailmango
 * @CreateDate 2020/4/25
 * @see com.jailmango.concurrence.imooc.course.basic.stop
 * @since R9.0
 */
public class RightWayInterrupted {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(RightWayInterrupted.class);

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {

            }
        });

        thread.start();
        thread.interrupt();

        // thread线程被中断了，返回true
        logger.info("is interrupted: [{}]", thread.isInterrupted());
        // 由于执行该语句的是main线程，因此返回false
        logger.info("is interrupted: [{}]", thread.interrupted());
        // 同上
        logger.info("is interrupted: [{}]", Thread.interrupted());
        // 由于thread线程的中断状态未被清除，因此返回true
        logger.info("is interrupted: [{}]", thread.isInterrupted());

        thread.join();

        logger.info("end...");
    }
}
