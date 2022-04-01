package com.jailmango.concurrence.book.core.chapter07;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 7.7.2 使用setDefaultUncaughtExceptionHandler()方法进行异常处理
 *
 * @author jailmango
 * @CreateDate 2020/9/10
 * @see com.jailmango.concurrence.book.core.chapter07
 * @since R9.0
 */
public class Case7_7_3 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case7_7_3.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Runnable runnable = () -> {
            String userName = null;
            logger.info("Hash-Code: {}", userName.hashCode());
        };

        Thread.setDefaultUncaughtExceptionHandler((t, e) -> {
            logger.info("Handle {} Exception...", t.getName());
            logger.info("", e);
        });

        Thread thread1 = new Thread(runnable);
        thread1.start();
        Thread thread2 = new Thread(runnable);
        thread2.start();
    }
}
