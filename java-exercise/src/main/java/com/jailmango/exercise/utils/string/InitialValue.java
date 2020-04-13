package com.jailmango.exercise.utils.string;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * InitialValue
 *
 * @author he.gang33
 * @CreateDate 2020/3/9
 * @see com.jailmango.exercise.utils.string
 * @since R9.0
 */
public class InitialValue {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(InitialValue.class);

    public boolean isNow;

    public static void main(String[] args) {
        InitialValue ins = new InitialValue();

        if (ins.isNow) {
            logger.info("true...");
        }
        else {
            logger.info("false...");
        }
    }

}
