package com.jailmango.nio.ifeve.chapter03;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * BufferCompactCase
 *
 * @author he.gang33
 * @CreateDate 2019-04-03
 * @see com.jailmango.nio.ifeve.chapter03
 * @since R9.0
 */
public class BufferCompactCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(BufferClearCase.class);

    /**
     * log template
     */
    private static final String LOG_TEMPLATE = "Position: [{}], Content: [{}], Limit: [{}]";

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
        ByteBuffer buffer = ByteBuffer.allocate(4);

        int byteRead = channel.read(buffer);

        int totalCount = 0;

        while (-1 != byteRead) {
            buffer.flip();
            while (buffer.hasRemaining()) {
                if (2 == buffer.position()) {
                    break;
                }
                logger.info(LOG_TEMPLATE, buffer.position(), buffer.get(), buffer.limit());
                totalCount++;
            }

            buffer.compact();
            logger.info("compact...");
            byteRead = channel.read(buffer);
            logger.info("read...");
        }

        logger.info("total: [{}]", totalCount);

    }
}
