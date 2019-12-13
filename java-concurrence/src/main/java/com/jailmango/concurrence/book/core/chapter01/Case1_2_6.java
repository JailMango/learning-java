package com.jailmango.concurrence.book.core.chapter01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case1_2_6 - 1.2.6 Runnable可以避免无法多继承
 *
 * @author he.gang33
 * @CreateDate 2019-05-20
 * @see com.jailmango.concurrence.book.core.chapter01
 * @since R9.0
 */
public class Case1_2_6 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case1_2_6.class);

    static class AServer {

        public void amethod() {
            logger.info("a method...");
        }
    }

    static class BServer extends AServer implements Runnable {

        @Override
        public void run() {
            logger.info("BServer running...");
        }

        public void bmethod() {
            logger.info("b method...");
        }
    }
}
