package com.jailmango.exercise.utils.string;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SubstringCase
 *
 * @author he.gang33
 * @CreateDate 2019/10/29
 * @see com.jailmango.exercise.utils.string
 * @since R9.0
 */
public class SubstringCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(SubstringCase.class);

    /**
     * main
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        String str = "1,2,3,4,5,6,7,8,9,0";
        logger.info(str.substring(1, 3));

        String[] arr;
        String s = "boo:and:foo";
        // 我们对 s 进行了各种拆分，演示的代码和结果是：
        arr = s.split(":");
        arr = s.split(":", 2);
        arr = s.split(":", 5);
        arr = s.split(":", -2);
        arr = s.split("o");
        arr = s.split("o", 2);
        arr = s.split("o", 3);
        logger.info("end...");
    }
}
