package com.jailmango.design.pattern.singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SingletonCase
 *
 * @author he.gang33
 * @CreateDate 2019-01-22
 * @see com.jailmango.java.design.pattern.singleton
 * @since R9.0
 */
public class SingletonCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(SingletonCase.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        logger.debug("begin...");

        SingletonObject obj = SingletonObject.getInstance();

        logger.debug("end...");
    }
}
