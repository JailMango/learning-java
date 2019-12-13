package com.jailmango.exercise.utils.string;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * StringBuilderCase
 *
 * @author he.gang33
 * @CreateDate 2019-03-28
 * @see com.jailmango.exercise.utils.string
 * @since R9.0
 */
public class StringBuilderCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(StringBuilderCase.class);

    public static void main(String[] args) {
        java.lang.StringBuilder str = new java.lang.StringBuilder("a");
        str.trimToSize();
        logger.info(str.toString());

        java.lang.StringBuilder sb = new java.lang.StringBuilder("a");
        logger.info("sb: [" + sb.toString() + "]");

        sb.append("b");
        logger.info("sb: [" + sb.toString() + "]");

        java.lang.StringBuilder sb1 = new java.lang.StringBuilder(sb);
        sb1.append("c");
        logger.info("sb1: [" + sb1.toString() + "]");

        logger.info("sb: [" + sb.toString() + "]");
    }
}
