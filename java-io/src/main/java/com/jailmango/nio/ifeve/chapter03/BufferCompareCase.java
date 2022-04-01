package com.jailmango.nio.ifeve.chapter03;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * BufferCompareCase
 *
 * @author jailmango
 * @CreateDate 2019-04-03
 * @see com.jailmango.nio.ifeve.chapter03
 * @since R9.0
 */
public class BufferCompareCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(BufferCompareCase.class);

    /**
     * main
     * 
     * @param args String[]
     * @throws IOException IOException
     */
    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile(
            "/Users/mango/Documents/repository/github/learning/file/nio-data.txt", "rw");
        FileChannel channel = file.getChannel();
        // create buffer with capacity of 1024 bytes
        ByteBuffer buffer = ByteBuffer.allocate(15);
        channel.read(buffer);
        buffer.flip();
        buffer.put((byte) 127);

        RandomAccessFile file1 = new RandomAccessFile(
            "/Users/mango/Documents/repository/github/learning/file/nio-data.txt", "rw");
        FileChannel channel1 = file1.getChannel();
        // create buffer with capacity of 1024 bytes
        ByteBuffer buffer1 = ByteBuffer.allocate(15);
        channel1.read(buffer1);
        buffer1.flip();

        logger.info(String.valueOf(buffer.compareTo(buffer1)));
    }
}
