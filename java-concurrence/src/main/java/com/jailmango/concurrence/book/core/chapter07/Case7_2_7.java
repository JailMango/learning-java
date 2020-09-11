package com.jailmango.concurrence.book.core.chapter07;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 7.2.7 递归去的与非递归取得组内对象
 *
 * @author he.gang33
 * @CreateDate 2020/9/7
 * @see com.jailmango.concurrence.book.core.chapter07
 * @since R9.0
 */
public class Case7_2_7 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case7_2_7.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        logger.info("[{}]活动线程组[{}]", mainGroup.getName(), mainGroup.activeGroupCount());
        ThreadGroup groupA = new ThreadGroup(mainGroup, "Group-A");
        logger.info("[{}]活动线程组[{}]", mainGroup.getName(), mainGroup.activeGroupCount());
        ThreadGroup groupB = new ThreadGroup(groupA, "Group-B");
        logger.info("[{}]活动线程组[{}]", mainGroup.getName(), mainGroup.activeGroupCount());

        ThreadGroup[] groups = new ThreadGroup[Thread.currentThread().getThreadGroup().activeGroupCount()];

        // 等价于 Thread.currentThread().getThreadGroup().enumerate(groups, true);
        Thread.currentThread().getThreadGroup().enumerate(groups);
        for (int i = 0; i < groups.length; i++) {
            logger.info("[{}]", groups[i].getName());
        }

        ThreadGroup[] groupsB = new ThreadGroup[Thread.currentThread().getThreadGroup().activeGroupCount()];
        Thread.currentThread().getThreadGroup().enumerate(groupsB, false);
        for (int i = 0; i < groupsB.length; i++) {
            if (null != groupsB[i]) {
                logger.info("[{}]", groupsB[i].getName());

            }
        }
    }
}
