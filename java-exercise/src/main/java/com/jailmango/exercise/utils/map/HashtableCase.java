package com.jailmango.exercise.utils.map;

import java.util.Enumeration;
import java.util.Hashtable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * HashtableCase
 *
 * @author he.gang33
 * @CreateDate 2019-07-08
 * @see com.jailmango.exercise.utils.map
 * @since R9.0
 */
public class HashtableCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(HashtableCase.class);

    public static void main(String[] args) {
        Hashtable<Integer, Integer> map = new Hashtable<>();

        for (int i = 0; i < 5; i++) {
            map.put(i, i);
        }

        Enumeration<Integer> keys = map.keys();

        while (keys.hasMoreElements()) {
            Integer key = keys.nextElement();
            logger.info("Value: [{}]", map.get(key));
        }

        logger.info("end...");
    }

}
