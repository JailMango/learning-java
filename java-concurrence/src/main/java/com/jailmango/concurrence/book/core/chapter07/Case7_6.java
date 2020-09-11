package com.jailmango.concurrence.book.core.chapter07;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 7.6 SimpleDateFormat非线程安全
 *
 * @author he.gang33
 * @CreateDate 2020/9/9
 * @see com.jailmango.concurrence.book.core.chapter07
 * @since R9.0
 */
public class Case7_6 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case7_6.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws ParseException {
        String dateString1 = "2020-1-1";
        String dateString2 = "2020-11-18";

        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-M-d");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");

        logger.info("{}", simpleDateFormat1.format(simpleDateFormat1.parse(dateString1)));
        logger.info("{}", simpleDateFormat2.format(simpleDateFormat2.parse(dateString1)));

        logger.info("------------------------");

        logger.info("{}", simpleDateFormat1.format(simpleDateFormat1.parse(dateString2)));
        logger.info("{}", simpleDateFormat2.format(simpleDateFormat2.parse(dateString2)));
    }
}
