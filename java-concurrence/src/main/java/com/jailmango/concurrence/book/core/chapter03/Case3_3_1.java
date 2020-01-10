package com.jailmango.concurrence.book.core.chapter03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case3_3_1 - ThreadLocal get()方法与null
 * ThreadLocal解决的是变量在不同线程的隔离性，也就是不同的线程拥有自己的值
 * @author he.gang33
 * @CreateDate 2019/12/19
 * @see com.jailmango.concurrence.book.core.chapter03
 * @since R9.0
 */
public class Case3_3_1 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case3_3_1.class);

    /**
     * threadLocal
     */
    public static ThreadLocal threadLocal = new ThreadLocal();

    /**
     * main
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        Object obj = threadLocal.get();

        if (null == obj) {
            logger.info("ThreadLocal从未放过值...");

            threadLocal.set("value");
        }

        logger.info("{}", threadLocal.get());
    }
}
