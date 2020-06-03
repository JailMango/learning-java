package com.jailmango.exercise.utils.string;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SplitCase
 *
 * @author he.gang33
 * @CreateDate 2020/4/30
 * @see com.jailmango.exercise.utils.string
 * @since R9.0
 */
public class SplitCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(SplitCase.class);

    public static void main(String[] args) {
        String key = "USER_NAME";
        logger.info("{}", toLowerCaseCamel(key));

    }

    private static String toLowerCaseCamel(String key) {
        StringBuffer sbf = new StringBuffer();
        String[] array = key.split("_");

        for (int index = 0; index < array.length; index++) {
            if (index != 0) {
                sbf.append(array[index].substring(0, 1).toUpperCase()).append(array[index].substring(1).toLowerCase());
            }
            else {
                sbf.append(array[index].toLowerCase());
            }
        }

        return sbf.toString();
    }
}
