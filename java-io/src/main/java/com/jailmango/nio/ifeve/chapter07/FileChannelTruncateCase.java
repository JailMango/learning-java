package com.jailmango.nio.ifeve.chapter07;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * FileChannelTruncateCase
 *
 * @author jailmango
 * @CreateDate 2019-04-09
 * @see com.jailmango.nio.ifeve.chapter07
 * @since R9.0
 */
public class FileChannelTruncateCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(FileChannelTruncateCase.class);

    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile(
            "/Users/mango/Documents/repository/github/learning/file/file-channel.txt", "rw");
        FileChannel channel = file.getChannel();
        channel.truncate(20);

        logger.info("end....");
    }
}
