package com.jailmango.concurrence.imooc.course.basic.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * BothRunnableAndThread <br/>
 * 同时使用Runnable和Thread
 * 
 * @author he.gang33
 * @CreateDate 2020/4/13
 * @see com.jailmango.concurrence.imooc.course.basic.create
 * @since R9.0
 */
public class BothRunnableAndThread {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(BothRunnableAndThread.class);

    /**
     * main
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        // 由于覆盖了Thread的run()方法，因此target.run()三行代码已经不在了。所以会打印from Thread...
        new Thread(() -> logger.info("from Runnable...")) {
            @Override
            public void run() {
                logger.info("from Thread...");
            }
        }.start();
    }
}
