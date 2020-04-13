package com.jailmango.exercise.utils.string;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * StringSplit
 *
 * @author he.gang33
 * @CreateDate 2019-06-26
 * @see com.jailmango.exercise.utils.string
 * @since R9.0
 */
public class StringSplit {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(StringSplit.class);

    public static void main(String[] args) {
        String str = "";
        String[] arr = str.split(",");

        String expr = "cond1||cond2||cond3";
        String result = expr.replaceAll("\\|\\|", "&&");

        logger.info("{}", result);

    }
}
