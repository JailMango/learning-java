package com.jailmango.concurrence.imooc.course.basic.create.wrongways;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * AnonymousInnerClassCase <br/>
 * 用匿名内部类的方式创建线程
 * 
 * @author jailmango
 * @CreateDate 2020/4/13
 * @see com.jailmango.concurrence.imooc.course.basic.create.wrongways
 * @since R9.0
 */
public class AnonymousInnerClassCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(AnonymousInnerClassCase.class);

    /**
     * main
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                logger.info("{} doing...", Thread.currentThread().getName());
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                logger.info("{} doing...", Thread.currentThread().getName());
            }
        }).start();

        new Thread(() -> logger.info("{} doing...", Thread.currentThread().getName())).start();
    }
}
