package com.jailmango.nio.ifeve.chapter12;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * NIOPathCase
 *
 * @author jailmango
 * @CreateDate 2019-04-12
 * @see com.jailmango.nio.ifeve.chapter12
 * @since R9.0
 */
public class NIOPathCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(NIOPathCase.class);

    public static void main(String[] args) {
        // 绝对路径创建Path实例
        Path path = Paths.get("/Users/mango/Documents/repository/github/learning/file/nio-data.txt");
        logger.info("Path: [{}]", path);

        Path path1 = Paths.get("/Users/mango/Documents/repository/github/learning", "file/nio-date.txt");
        logger.info("Path: [{}]", path1);

        Path path2 = Paths.get(".");
        logger.info("Path: [{}]", path2.toAbsolutePath().normalize());

        Path path3 = Paths.get("..");
        logger.info("Path: [{}]", path3.toAbsolutePath().normalize());

        logger.info("end...");
    }
}
