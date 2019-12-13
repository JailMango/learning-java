package com.jailmango.concurrence.book.core.old;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SleepRunnable
 *
 * @author he.gang33
 * @CreateDate 2018-11-28
 * @see com.jailmango.java.book.core.chapter01
 * @since R9.0<br>
 */
public class SleepRunnable implements Runnable {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(SleepRunnable.class);

    @Override
    public void run() {
        try {
            logger.info("running start....");
            Thread.sleep(200000);
        }
        catch (InterruptedException e) {
            logger.info("在沉睡中被停止! 捕获异常! " + Thread.currentThread().isInterrupted());
            logger.error(e.getLocalizedMessage());
        }
    }
}
