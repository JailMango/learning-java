package com.jailmango.exercise.utils.calculate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * BitOperation - 位运算
 *
 * @author he.gang33
 * @CreateDate 2019-01-03
 * @see com.jailmango.exercise.utils.calculate
 * @since R9.0<br>
 */
public class BitOperation {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(BitOperation.class);

    /**
     * main
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        int num1 = 4;

        for (int i = 1; i < 5; i++) {
            logger.info("左移{}位 -> {}", i, (num1 << i));
        }
    }
}
