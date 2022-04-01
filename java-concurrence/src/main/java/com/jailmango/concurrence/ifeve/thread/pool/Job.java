package com.jailmango.concurrence.ifeve.thread.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Job
 *
 * @author jailmango
 * @CreateDate 2018/11/15
 * @see com.jailmango.java.concurrence.ifeve.thread.pool
 * @since R9.0<br>
 */
public class Job implements Runnable {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Job.class);

    @Override
    public void run() {
        logger.info("start doing job[" + Thread.currentThread().getName() + "]");

        try {
            Thread.sleep(2500);
        }
        catch (InterruptedException e) {
            System.out.println(e.getLocalizedMessage());
        }

        logger.info("end doing job[" + Thread.currentThread().getName() + "]");
    }
}
