package com.jailmango.nio.ifeve.chapter07;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * FileChannelCase
 *
 * @author he.gang33
 * @CreateDate 2019-04-08
 * @see com.jailmango.nio.ifeve.chapter07
 * @since R9.0
 */
public class FileChannelCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(FileChannelCase.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile(
            "/Users/mango/Documents/repository/github/learning/file/file-channel.txt", "rw");
        FileChannel channel = file.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(48);
        getFileSize(channel);
        String msg = "New String to write to file..." + System.currentTimeMillis();
        buffer.clear();
        buffer.put(msg.getBytes(StandardCharsets.UTF_8));
        getFileSize(channel);
        buffer.flip();

        while (buffer.hasRemaining()) {
            channel.write(buffer);
            getFileSize(channel);
        }

        getFileSize(channel);
        channel.close();
    }

    private static void setPosition(FileChannel channel, Long position) throws IOException {
        Long pos = channel.position();
        channel.position(pos + position);
    }

    private static void getFileSize(FileChannel channel) throws IOException {
        logger.info("File Size: [{}]", channel.size());
    }
}
