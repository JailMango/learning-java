package com.jailmango.exercise.utils.string;

import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * StringCase
 *
 * @author he.gang33
 * @CreateDate 2019-03-20
 * @see com.jailmango.exercise.utils.string
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
        String content = "abc";
        char[] carr = content.toCharArray();
        for (int i = 0; i < carr.length; i++) {
            logger.info("{}", carr[i]);
        }

        String condition = null;

        switch (condition) {
            case "1":
                logger.info("1");
                break;
            case "2":
                logger.info("2");
                break;
            default:
                logger.info("default");
                break;
        }


        String hexStr = Hex.encodeHexString("000000000000000001:1=1,64=-1".getBytes());

        String longStr = "1234567890";
        logger.info(longStr.substring(1));

        String a = "a";
        String b = "b";

        String arr = String.join(",", a, b);

        String str = null;

        switch (str) {
            case "a":
                logger.info("a");
                break;
            case "b":
                logger.info("b");
                break;
            default:
                logger.info("default");
                break;
        }

        String a1 = "201701";
        String a2 = "201709";
        String a3 = "201710";
        String a4 = "201712";
        String a5 = "201801";



    }
}
