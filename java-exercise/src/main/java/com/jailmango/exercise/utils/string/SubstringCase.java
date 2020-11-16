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
        str = "1234567890";
        logger.info("{}", str.substring(3, 6));

        // String[] arr;
        // String s = "boo:and:foo";
        // // 我们对 s 进行了各种拆分，演示的代码和结果是：
        // arr = s.split(":");
        // arr = s.split(":", 2);
        // arr = s.split(":", 5);
        // arr = s.split(":", -2);
        // arr = s.split("o");
        // arr = s.split("o", 2);
        // arr = s.split("o", 3);
        //
        // String fileName = "Map.xml";
        // String result = getFileNameWithoutFileType(fileName);
        //
        // logger.info("end...");
    }

    /**
     * 获取文件后缀
     *
     * @param fileName String
     * @return String
     */
    private static String getFileSuffix(String fileName) {
        return fileName.substring(fileName.indexOf('.'), fileName.length());
    }

    /**
     * 获取文件名，不包括后缀
     *
     * @param fileName String
     * @return String
     */
    private static String getFileNameWithoutFileType(String fileName) {
        return fileName.replace(getFileSuffix(fileName), "");
    }
}
