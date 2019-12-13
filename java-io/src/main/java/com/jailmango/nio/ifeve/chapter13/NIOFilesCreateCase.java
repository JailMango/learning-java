package com.jailmango.nio.ifeve.chapter13;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * NIOFilesCreateCase
 *
 * @author he.gang33
 * @CreateDate 2019-04-12
 * @see com.jailmango.nio.ifeve.chapter13
 * @since R9.0
 */
public class NIOFilesCreateCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(NIOFilesCreateCase.class);

    /**
     * main
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        Path path = Paths.get("/Users/mango/Documents/repository/github/learning/tmp");
        try {
            Files.createDirectory(path);
        }
        catch (IOException e) {
            logger.error("Fail to create directory[{}]...", path.toAbsolutePath());
            e.printStackTrace();
        }

        Path path1 = Paths.get("/Users/mango/Documents/repository/github/learning/tmp/tmp");
        try {
            Files.createDirectory(path1);
        }
        catch (IOException e) {
            logger.error("Fail to create directory[{}]...", path1.toAbsolutePath());
            e.printStackTrace();
        }
    }
}
