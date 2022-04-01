package com.jailmango.exercise.utils.string;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * StringContainsCase
 *
 * @author jailmango
 * @CreateDate 2020/1/7
 * @see com.jailmango.exercise.utils.string
 * @since R9.0
 */
public class StringContainsCase {
    
    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(StringContainsCase.class);

    /**
     * main
     * @param args String[]
     */
    public static void main(String[] args) {
        String filePath = "/Users/mango/Documents/re/./re/map.xml";

        if (filePath.contains("../")) {
            logger.info("../");
        }
        else if (filePath.contains("./")) {
            logger.info("./");
        }
        else {
            logger.info("false");
        }
        
    }
}
