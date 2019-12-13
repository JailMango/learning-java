package com.jailmango.nio.ifeve.chapter03;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * BufferEqualsCase
 *
 * @author he.gang33
 * @CreateDate 2019-04-03
 * @see com.jailmango.nio.ifeve.chapter03
 * @since R9.0
 */
public class BufferEqualsCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(BufferEqualsCase.class);

    /**
     * main
     *
     * @param args String[]
     * @throws IOException IOException
     */
    public static void main(String[] args) throws IOException {
        equals();
    }

    /**
     * equals
     * 
     * @throws IOException IOException
     */
    private static void equals() throws IOException {
        RandomAccessFile file = new RandomAccessFile(
            "/Users/mango/Documents/repository/github/learning/file/nio-data.txt", "rw");
        FileChannel channel = file.getChannel();
        // create buffer with capacity of 1024 bytes
        ByteBuffer buffer = ByteBuffer.allocate(15);
        channel.read(buffer);
        buffer.flip();

        RandomAccessFile file1 = new RandomAccessFile(
            "/Users/mango/Documents/repository/github/learning/file/nio-data.txt", "rw");
        FileChannel channel1 = file1.getChannel();
        // create buffer with capacity of 1024 bytes
        ByteBuffer buffer1 = ByteBuffer.allocate(15);
        channel1.read(buffer1);
        buffer1.flip();

        RandomAccessFile file2 = new RandomAccessFile(
            "/Users/mango/Documents/repository/github/learning/file/nio-data-1.txt", "rw");
        FileChannel channel2 = file2.getChannel();
        // create buffer with capacity of 1024 bytes
        ByteBuffer buffer2 = ByteBuffer.allocate(15);
        channel2.read(buffer2);
        buffer2.flip();

        // 未操作两个buffer
        logger.info("未操作: [" + buffer.equals(buffer1) + "]");

        // 两个buffer剩余元素不等
        buffer.get();
        logger.info("buffer get() 1次: [" + buffer.equals(buffer1) + "]");

        // 元素内容不同
        logger.info("元素内容不同: [" + buffer.equals(buffer1) + "]");
    }
}
