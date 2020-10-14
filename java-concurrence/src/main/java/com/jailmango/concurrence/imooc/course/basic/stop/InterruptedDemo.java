package com.jailmango.concurrence.imooc.course.basic.stop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * InterruptedDemo
 *
 * @author he.gang33
 * @CreateDate 2020/4/25
 * @see com.jailmango.concurrence.imooc.course.basic.stop
 * @since R9.0
 */
public class InterruptedDemo {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(InterruptedDemo.class);

    public static void main(String[] args) {
        Thread thread = new Thread(() -> logger.info("running..."));
        thread.start();
        Thread.interrupted();
        thread.isInterrupted();
    }
}
