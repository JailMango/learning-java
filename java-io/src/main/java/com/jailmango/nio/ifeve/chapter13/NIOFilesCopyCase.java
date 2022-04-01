package com.jailmango.nio.ifeve.chapter13;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * NIOFilesCopyCase
 *
 * @author jailmango
 * @CreateDate 2019-04-12
 * @see com.jailmango.nio.ifeve.chapter13
 * @since R9.0
 */
public class NIOFilesCopyCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(NIOFilesCopyCase.class);

    /**
     * main
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        Path sourcePath = Paths.get("/Users/mango/Documents/repository/github/learning/tmp/tmp/nio-data.txt");
        Path destinationPath = Paths.get("/Users/mango/Documents/repository/github/learning/tmp/tmp/nio-data1.txt");

        try {
            // 不能覆盖，若文件存在，则报错
            Files.copy(sourcePath, destinationPath);
            logger.info("copy files without overwritting...");
        }
        catch (IOException e) {
            logger.error("Fail to copy files...");
            e.printStackTrace();
        }

        try {
            Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
            logger.info("copy files with overwritting...");
        }
        catch (IOException e) {
            logger.error("Fail to copy files...");
            e.printStackTrace();
        }
    }
}
