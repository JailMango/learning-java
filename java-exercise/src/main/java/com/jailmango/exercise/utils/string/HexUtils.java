package com.jailmango.exercise.utils.string;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * HexUtils
 *
 * @author he.gang33
 * @CreateDate 2019-08-19
 * @see com.jailmango.exercise.utils.string
 * @since R9.0
 */
public class HexUtils {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(HexUtils.class);

    public static void main(String[] args) {
        int i = Integer.reverseBytes(16777216);

        logger.info("{}", i);
    }

}
