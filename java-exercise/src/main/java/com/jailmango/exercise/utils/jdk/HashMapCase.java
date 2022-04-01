package com.jailmango.exercise.utils.jdk;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * HashMapCase
 *
 * @author jailmango
 * @CreateDate 2020/9/28
 * @see com.jailmango.exercise.utils.jdk
 * @since R9.0
 */
public class HashMapCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(HashMapCase.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < 16; i++) {
            map.put(Integer.toString(i), Integer.toBinaryString(i));
        }

        logger.info("end...");
    }
}
