package com.jailmango.jdk.source.interview.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * try-catch-finally关键字理解
 *
 * @author jailmango
 * @CreateDate 2019/10/29
 * @see com.jailmango.jdk.source.interview.basic
 * @since R9.0
 */
public class TryCatchFinallyCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(TryCatchFinallyCase.class);

    public static void main(String[] args) {
        testMethod();
    }

    private static void testMethod() {
        try {
            logger.info("try is running...");

            if (true) {
                throw new RuntimeException("try throws exception...");
            }
        }
        catch (Exception e) {
            logger.info("catch is running...");

            if (true) {
                throw new RuntimeException("catch throw exception...");
            }
        }
        finally {
            logger.info("finally is running...");
        }
    }
}
