package com.jailmango.nio.ifeve.chapter13;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * NIOFilesWalkFileTreeCase
 *
 * @author jailmango
 * @CreateDate 2019-04-12
 * @see com.jailmango.nio.ifeve.chapter13
 * @since R9.0
 */
public class NIOFilesWalkFileTreeCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(NIOFilesWalkFileTreeCase.class);

    /**
     * main
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        loop();
        delete();
    }

    /**
     * 遍历
     */
    private static void loop() {
        Path path = Paths.get("/Users/mango/Documents/repository/github/learning/file");

        try {
            Files.walkFileTree(path, new FileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    logger.info("Pre visit directory: [{}], Is directory: [{}]", dir, attrs.isDirectory());
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    logger.info("Visit file: [{}], Is directory: [{}]", file, attrs.isDirectory());
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    logger.info("Visit file failed: [{}]", file);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    logger.info("Post visit direcotry: [{}]", dir);
                    return FileVisitResult.CONTINUE;
                }
            });
        }
        catch (IOException e) {
            logger.error("Fail to walkFileTree...");
            e.printStackTrace();
        }
    }

    /**
     * 删除
     */
    private static void delete() {
        Path path = Paths.get("/Users/mango/Documents/repository/github/learning/file-del");

        try {
            Files.walkFileTree(path, new FileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    logger.info("Pre visit directory: [{}], Is directory: [{}]", dir, attrs.isDirectory());
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    logger.info("Delete file: [{}], Is directory: [{}]", file, attrs.isDirectory());
                    Files.delete(file);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    logger.info("Visit file failed: [{}]", file);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    logger.info("Delete visit direcotry: [{}]", dir);
                    Files.delete(dir);
                    return FileVisitResult.CONTINUE;
                }
            });
        }
        catch (IOException e) {
            logger.error("Fail to walkFileTree...");
            e.printStackTrace();
        }
    }
}
