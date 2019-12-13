package com.jailmango.nio.ifeve.chapter04;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * GatheringWrites
 *
 * @author he.gang33
 * @CreateDate 2019-04-03
 * @see com.jailmango.nio.ifeve.chapter04
 * @since R9.0
 */
public class GatheringWrites {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(GatheringWrites.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws IOException {
        ByteBuffer header = ByteBuffer.allocate(10);
        header.put("header".getBytes());
        header.flip();
        ByteBuffer body = ByteBuffer.allocate(20);
        body.put("hello world".getBytes());
        body.flip();

        ByteBuffer[] bufferArray = {
            header, body
        };

        RandomAccessFile file = new RandomAccessFile(
            "/Users/mango/Documents/repository/github/learning/file/gathering-writes-data.txt", "rw");
        FileChannel channel = file.getChannel();

        long byteWrite = channel.write(bufferArray);
        logger.info(String.valueOf(byteWrite));


        logger.info("end...");
    }
}
