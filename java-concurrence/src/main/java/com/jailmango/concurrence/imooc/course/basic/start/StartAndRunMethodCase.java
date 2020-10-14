package com.jailmango.concurrence.imooc.course.basic.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * StartAndRunMethodCase <br/>
 * 比较start()和run()
 * 
 * @author he.gang33
 * @CreateDate 2020/4/14
 * @see com.jailmango.concurrence.imooc.course.basic.start
 * @since R9.0
 */
public class StartAndRunMethodCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(StartAndRunMethodCase.class);

    /**
     * main
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        Runnable runnable = () -> logger.info("{} doing...", Thread.currentThread().getName());

        runnable.run();
        new Thread(runnable).start();
    }
}
