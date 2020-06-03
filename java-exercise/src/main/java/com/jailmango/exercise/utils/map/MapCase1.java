package com.jailmango.exercise.utils.map;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * MapCase1
 *
 * @author he.gang33
 * @CreateDate 2019-04-01
 * @see com.jailmango.exercise.utils.map
 * @since R9.0
 */
public class MapCase1 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(MapCase1.class);

    /**
     * main
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>(10);

        for (int i = 0; i < 10; i++) {
            map.put(String.valueOf(i), i);
        }

        map.forEach((key, value) -> logger.info("Key[{}] Value[{}]", key, value));
    }
}
