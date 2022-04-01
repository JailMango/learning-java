package com.jailmango.nio.ifeve.chapter13;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * NIOFilesMoveCase
 *
 * @author jailmango
 * @CreateDate 2019-04-12
 * @see com.jailmango.nio.ifeve.chapter13
 * @since R9.0
 */
public class NIOFilesMoveCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(NIOFilesMoveCase.class);

    /**
     * main
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        Path sourcePath = Paths.get("/Users/mango/Documents/repository/github/learning/tmp/tmp/nio-data.txt");
        Path destinationPath = Paths
            .get("/Users/mango/Documents/repository/github/learning/tmp/tmp/move/nio-data2.txt");

        try {
            // move()操作，移动和重命名
            // 不覆盖
            Files.move(sourcePath, destinationPath);
            // 覆盖
            Files.move(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
        }
        catch (IOException e) {
            logger.error("Fail to move file...");
            e.printStackTrace();
        }

        logger.info("end...");
    }
}
