package com.jailmango.jdk.source.interview.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * StringMain
 *
 * @author he.gang33
 * @CreateDate 2019/10/28
 * @see com.jailmango.jdk.source.interview.basic
 * @since R9.0
 */
public class StringCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(StringCase.class);

    /**
     * main
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        // 通过比较str地址，可以发现，str地址改变。体现不可变性。
        String str = "hello";
        str = "World";

        logger.info("String-Case end...");
    }
}
