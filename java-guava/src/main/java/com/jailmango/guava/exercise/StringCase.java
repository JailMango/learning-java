package com.jailmango.guava.exercise;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * StringCase
 *
 * @author jailmango
 * @CreateDate 2019/10/29
 * @see com.jailmango.guava.exercise
 * @since R9.0
 */
public class StringCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(StringCase.class);

    public static void main(String[] args) {
        String s = "a, , b,  c, d";

        String[] arr;
        arr = s.split(",");

        // 使用Guava
        List<String> list = Splitter.on(",").trimResults().omitEmptyStrings().splitToList(s);

        Joiner joiner = Joiner.on(",").skipNulls();
        logger.info(joiner.join("Hello", null, "World", "", "!"));

        logger.info("end...");
    }
}
