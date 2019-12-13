package com.jailmango.nio.ifeve.chapter13;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * NIOFilesDeleteCase
 *
 * @author he.gang33
 * @CreateDate 2019-04-12
 * @see com.jailmango.nio.ifeve.chapter13
 * @since R9.0
 */
public class NIOFilesDeleteCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(NIOFilesDeleteCase.class);

    public static void main(String[] args) {
        Path path = Paths.get("/Users/mango/Documents/repository/github/learning/file/nio-data-del.txt");

        try {
            // 若文件不存在，则会抛出异常
            Files.delete(path);
        }
        catch (IOException e) {
            logger.info("Fail to delete files...");
            e.printStackTrace();
        }

        try {
            // 文件不存在，不会抛异常，与delete()方法有区别
            Files.deleteIfExists(path);
        }
        catch (IOException e) {
            logger.info("Fail to delete files...");
            e.printStackTrace();
        }

        logger.info("end...");
    }
}
