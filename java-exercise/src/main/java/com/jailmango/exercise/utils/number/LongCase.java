package com.jailmango.exercise.utils.number;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * LongCase
 *
 * @author jailmango
 * @CreateDate 2019-04-01
 * @see com.jailmango.exercise.utils.number
 * @since R9.0
 */
public class LongCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(LongCase.class);

    /**
     * main
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        Long a = 1L;

        Long b = Math.abs(a);

        LongDto dto = new LongDto();
        Long id = 0L;
        id = dto.getId();
        int c = 1;

        Long sms = 40001L;
        Long email = 40001L;

        if (sms.equals(email)) {
            logger.info("true");
        }
        else {
            logger.info("false");
        }

        Long zero = 2L;

        if (0 < zero) {
            logger.info("zero = 0");
        }
        else {
            logger.info("zero != 0");
        }
    }
}
