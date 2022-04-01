package com.jailmango.concurrence.book.core.chapter03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case3_3_4 - 3.3.4 解决get()方法返回null的问题
 *
 * @author jailmango
 * @CreateDate 2019/12/20
 * @see com.jailmango.concurrence.book.core.chapter03
 * @since R9.0
 */
public class Case3_3_4 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case3_3_4.class);

    /**
     * ThreadLocal
     */
    public static ThreadLocalExt threadLocalExt = new ThreadLocalExt();

    /**
     * main
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        if (null != threadLocalExt.get()) {
            logger.info("Initial Value: [{}]", threadLocalExt.get());
        }
        else {
            logger.info("Initial Value is null...");
        }
    }

    private static class ThreadLocalExt extends ThreadLocal {

        @Override
        protected Object initialValue() {
            return "default value";
        }
    }
}
