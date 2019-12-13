package com.jailmango.exercise.utils.if_else;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * IfElseCase
 *
 * @author he.gang33
 * @CreateDate 2019-06-26
 * @see com.jailmango.exercise.utils.if_else
 * @since R9.0
 */
public class IfElseCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(IfElseCase.class);

    public static void main(String[] args) {

        for (int i = 1; i < 10; i++) {
            logger.info("{}", i);
            if (5 == i)
                logger.info("break...");
            break;
        }

        logger.info("=============================================");

        logger.info("{}", calculate());
    }

    public static String calculate() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (j == 3) {
                    return "j" + (i * j);
                }
                else {
                    continue;
                }
            }
        }

        return "0";
    }

}
