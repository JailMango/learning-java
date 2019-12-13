package com.jailmango.nio.ifeve.chapter05;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ChannelToChannel
 *
 * @author he.gang33
 * @CreateDate 2019-04-04
 * @see com.jailmango.nio.ifeve.chapter05
 * @since R9.0
 */
public class ChannelToChannel {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ChannelToChannel.class);

    /**
     * main
     *
     * @param args String[]
     * @throws IOException IOException
     */
    public static void main(String[] args) throws IOException {
        RandomAccessFile fromFile = new RandomAccessFile(
            "/Users/mango/Documents/repository/github/learning/file/nio-data.txt", "rw");
        FileChannel fromChannel = fromFile.getChannel();

        RandomAccessFile toFile1 = new RandomAccessFile(
            "/Users/mango/Documents/repository/github/learning/file/to1.txt", "rw");
        FileChannel toChannel1 = toFile1.getChannel();

        transferFrom(fromChannel, toChannel1);

        RandomAccessFile toFile2 = new RandomAccessFile(
            "/Users/mango/Documents/repository/github/learning/file/to2.txt", "rw");
        FileChannel toChannel2 = toFile2.getChannel();

        transferTo(toChannel1, toChannel2);
    }

    /**
     * transferFrom
     *
     * @param fromChannel FileChannel
     * @param toChannel FileChannel
     * @throws IOException IOException
     */
    private static void transferFrom(FileChannel fromChannel, FileChannel toChannel) throws IOException {
        toChannel.transferFrom(fromChannel, 0L, fromChannel.size());
    }

    /**
     * transferTo
     *
     * @param fromChannel FileChannel
     * @param toChannel FileChannel
     * @throws IOException IOException
     */
    private static void transferTo(FileChannel fromChannel, FileChannel toChannel) throws IOException {
        fromChannel.transferTo(0L, fromChannel.size(), toChannel);
    }
}
