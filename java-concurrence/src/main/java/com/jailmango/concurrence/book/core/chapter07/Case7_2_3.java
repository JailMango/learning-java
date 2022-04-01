package com.jailmango.concurrence.book.core.chapter07;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 7.2.3 线程组自动归属属性
 *
 * @author jailmango
 * @CreateDate 2020/9/7
 * @see com.jailmango.concurrence.book.core.chapter07
 * @since R9.0
 */
public class Case7_2_3 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case7_2_3.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        logger.info("线程[{}]所属的线程组[{}], 线程组数量[{}]", Thread.currentThread().getName(),
            Thread.currentThread().getThreadGroup().getName(),
            Thread.currentThread().getThreadGroup().activeGroupCount());

        // 若不指定所属的线程组，则自动归属当前线程对象所属的线程组中
        ThreadGroup newGroup = new ThreadGroup("New-Group");

        logger.info("线程[{}]所属的线程组[{}], 线程组数量[{}]", Thread.currentThread().getName(),
            Thread.currentThread().getThreadGroup().getName(),
            Thread.currentThread().getThreadGroup().activeGroupCount());

        ThreadGroup[] groups = new ThreadGroup[Thread.currentThread().getThreadGroup().activeGroupCount()];
        Thread.currentThread().getThreadGroup().enumerate(groups);

        for (int i = 0; i < groups.length; i++) {
            logger.info("线程组[{}]", groups[i].getName());
        }
    }
}
