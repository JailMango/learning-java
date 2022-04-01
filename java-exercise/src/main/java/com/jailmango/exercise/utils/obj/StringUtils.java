package com.jailmango.exercise.utils.obj;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * StringUtils
 *
 * @author jailmango
 * @CreateDate 2020/4/20
 * @see com.jailmango.exercise.utils.obj
 * @since R9.0
 */
public class StringUtils {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(StringUtils.class);

    public static void main(String[] args) {
        String tmp = "01234";
        logger.info(tmp.substring(0, 5));
        String key = "IUserNameU";
        logger.info(toUpperCaseAndUnderline(key));
    }

    private static String toUpperCaseAndUnderline(String data) {
        StringBuffer sbf = new StringBuffer();
        int begin = 0;

        for (int index = 0; index < data.length(); index++) {
            if (Character.isUpperCase(data.charAt(index))) {
                if (begin < index) {
                    sbf.append(data.substring(begin, index).toUpperCase()).append("_");
                }
                begin = index;
            }
        }

        sbf.append(data.substring(begin));

        return sbf.toString();
    }
}
