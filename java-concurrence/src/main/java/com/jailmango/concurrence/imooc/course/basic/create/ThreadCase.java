package com.jailmango.concurrence.imooc.course.basic.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ThreadCase 用Thread类实现创建线程
 * 
 * @author he.gang33
 * @CreateDate 2020/4/13
 * @see com.jailmango.concurrence.imooc.course.basic.create
 * @since R9.0
 */
public class ThreadCase extends Thread {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ThreadCase.class);

    /**
     * main
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        new ThreadCase().start();
    }

    @Override
    public void run() {
        logger.info("用Thread类实现线程...");
    }
}
