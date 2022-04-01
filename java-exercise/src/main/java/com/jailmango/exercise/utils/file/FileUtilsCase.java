package com.jailmango.exercise.utils.file;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * FileUtilsCase [common-io]
 *
 * @author jailmango
 * @CreateDate 2019-05-16
 * @see com.jailmango.exercise.utils.file
 * @since R9.0
 */
public class FileUtilsCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(FileUtilsCase.class);

    public static void main(String[] args) {
        String path = "/Users/mango/Documents/repository/github/learning-java/";

        File file = FileUtils.getFile(path);

        logger.info(String.valueOf(file.isDirectory()));

        File oth = new File("/Users/mango/Documents/repository/github/learning-java/");

        int a = 1;
    }
}
