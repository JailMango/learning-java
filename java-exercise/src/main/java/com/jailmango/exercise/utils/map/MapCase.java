package com.jailmango.exercise.utils.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * MapCase
 *
 * @author he.gang33
 * @CreateDate 2018-12-17
 * @see com.jailmango.exercise.utils.map
 * @since R9.0<br>
 */
public class MapCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(MapCase.class);

    /**
     * main
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>(10);

        for (int index = 0; index < 10; index++) {
            map.put(index, "value[" + index + "]");
        }

        // keySet
        Set<Integer> keySet = map.keySet();
        Iterator<Integer> keyIterator = keySet.iterator();

        while (keyIterator.hasNext()) {
            logger.info("keySet - Iterator - [" + keyIterator.next() + "]");
        }

        // entrySet
        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
        Iterator<Map.Entry<Integer, String>> entryIterator = entrySet.iterator();
        Map.Entry<Integer, String> entry;

        while (entryIterator.hasNext()) {
            entry = entryIterator.next();
            logger.info("entrySet - Iterator - Key[" + entry.getKey() + "] - Value[" + entry.getValue() + "]");
        }

        logger.info("end...");
    }

}
