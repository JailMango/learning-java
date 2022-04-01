package com.jailmango.concurrence.imooc.note.chapter01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * DaemonCase2
 *
 * @author jailmango
 * @CreateDate 2019-02-27
 * @see com.jailmango.imooc.note.chapter01
 * @since R9.0
 */
public class DaemonCase2 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(DaemonCase2.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {

    }

    static class WriteLogThread implements Runnable {

        @Override
        public void run() {

        }
    }

    static class CleanLogThread implements Runnable {

        @Override
        public void run() {

        }
    }

}
