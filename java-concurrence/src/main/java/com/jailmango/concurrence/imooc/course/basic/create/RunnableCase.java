package com.jailmango.concurrence.imooc.course.basic.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * RunnableCase <br/>
 * 用Runnable方式创建线程
 * 
 * @author jailmango
 * @CreateDate 2020/4/13
 * @see com.jailmango.concurrence.imooc.course.basic.create
 * @since R9.0
 */
public class RunnableCase implements Runnable {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(RunnableCase.class);

    /**
     * main
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableCase());
        thread.start();
    }

    @Override
    public void run() {
        logger.info("用Runnable接口实现线程...");
    }

}
