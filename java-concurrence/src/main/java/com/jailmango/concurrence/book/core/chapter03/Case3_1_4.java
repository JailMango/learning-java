package com.jailmango.concurrence.book.core.chapter03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case3_1_4
 *
 * @author he.gang33
 * @CreateDate 2019-05-31
 * @see com.jailmango.concurrence.book.core.chapter03
 * @since R9.0
 */
public class Case3_1_4 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case3_1_4.class);

    public static void main(String[] args) {

    }

    /**
     * 本例出现报错，原因是因为该段代码未持有锁。
     */
    private static void case1() {
        String str = new String();
        try {
            str.wait();
        }
        catch (InterruptedException e) {
            logger.error(e.getLocalizedMessage());
        }
    }

    /**
     * 可正常执行wait()，并且所在线程处于等待状态，一直未结束。 可使用notify()，唤醒wait状态线程继续执行。
     */
    private static void case2() {
        try {
            String lock = new String();
            logger.info("before synchronized block...");

            synchronized (lock) {
                logger.info("1st line in synchronized block...");
                lock.wait();
                logger.info("after wait...");
            }

            logger.info("after synchronized block...");
        }
        catch (InterruptedException e) {
            logger.error(e.getLocalizedMessage());
        }
    }
}
