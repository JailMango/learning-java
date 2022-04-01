package com.jailmango.concurrence.imooc.course.basic.create.wrongways;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ThreadPoolCase <br/>
 * 用线程池创建线程，从本质上看，并不是一种新的创建线程的方式
 * 
 * @author jailmango
 * @CreateDate 2020/4/13
 * @see com.jailmango.concurrence.imooc.course.basic.create.wrongways
 * @since R9.0
 */
public class ThreadPoolCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ThreadPoolCase.class);

    /**
     * main
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            service.submit(new Task());
        }
    }

    private static class Task implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(300);
            }
            catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }

            logger.info("{} doing task...", Thread.currentThread().getName());
        }
    }
}
