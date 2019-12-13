package com.jailmango.nio.ifeve.chapter13;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * NIOFilesExistsCase
 *
 * @author he.gang33
 * @CreateDate 2019-04-12
 * @see com.jailmango.nio.ifeve.chapter13
 * @since R9.0
 */
public class NIOFilesExistsCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(NIOFilesExistsCase.class);

    /**
     * main
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        Path path = Paths.get("/Users/mango/Documents/repository/github/learning/file/nio-data.txt");
        boolean isExists = Files.exists(path, LinkOption.NOFOLLOW_LINKS);
        boolean isNotExists = Files.notExists(path, LinkOption.NOFOLLOW_LINKS);
        logger.info("Path: [{}], Is exsits: [{}], Is not exists: [{}]", path.toAbsolutePath(), isExists, isNotExists);

        Path path1 = Paths.get("/Users/mango/Documents/repository/github/learning/file/nio-data1.txt");
        boolean isExists1 = Files.exists(path1, LinkOption.NOFOLLOW_LINKS);
        boolean isNotExists1 = Files.notExists(path1, LinkOption.NOFOLLOW_LINKS);
        logger.info("Path: [{}], Is exsits: [{}], Is not exists: [{}]", path1.toAbsolutePath(), isExists1,
            isNotExists1);
    }
}
