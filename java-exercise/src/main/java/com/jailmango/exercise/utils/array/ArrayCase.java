package com.jailmango.exercise.utils.array;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ArrayCase
 *
 * @author he.gang33
 * @CreateDate 2019-05-10
 * @see com.jailmango.exercise.utils.array
 * @since R9.0
 */
public class ArrayCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ArrayCase.class);

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");

        String str = StringUtils.join(set.toArray(), ",");

        logger.info(str);

        int a = 1;

        while (true) {
            logger.info("a = {}", a);
            a++;

            if (a == 10) {
                break;
            }
        }

        logger.info("end loop...");
        logger.info("a = {}", a);

        Long x = 2L;
        Long y = 5L;

        long z = x * y;
        logger.info("{}", z);
    }
}
