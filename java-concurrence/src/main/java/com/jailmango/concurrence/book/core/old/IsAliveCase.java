package com.jailmango.concurrence.book.core.old;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * IsAliveCase
 *
 * @author jailmango
 * @CreateDate 2019-03-14
 * @see com.jailmango.java.book.core.chapter01
 * @since R9.0
 */
public class IsAliveCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(IsAliveCase.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Thread thread = new Thread(new IsAliveThread());
        thread.start();
    }

    private static class IsAliveThread extends Thread {

        @Override
        public void run() {
            logger.info("Is alive? [" + this.isAlive() + "]");
        }
    }

}
