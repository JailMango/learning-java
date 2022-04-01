package com.jailmango.nio.ifeve.chapter14;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * AsynchronousFileChannelReadingCase
 *
 * @author jailmango
 * @CreateDate 2019-04-17
 * @see com.jailmango.nio.ifeve.chapter14
 * @since R9.0
 */
public class AsynchronousFileChannelReadingCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(AsynchronousFileChannelReadingCase.class);

    /**
     * main
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        // readViaFuture();
        readViaCompletionHandler();
    }

    /**
     * readViaFuture
     */
    private static void readViaFuture() {
        logger.info("readViaFuture...");
        Path path = Paths.get("/Users/mango/Documents/repository/github/learning/file/file1.log");
        try {
            AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            Future<Integer> operation = fileChannel.read(buffer, 0);

            while (!operation.isDone()) {

            }

            buffer.flip();
            byte[] data = new byte[buffer.limit()];
            buffer.get(data);
            logger.info(new String(data));
            buffer.clear();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * readViaCompletionHandler
     */
    private static void readViaCompletionHandler() {
        logger.info("readViaCompletionHandler...");
        Path path = Paths.get("/Users/mango/Documents/repository/github/learning/file/file1.log");
        try {
            AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            fileChannel.read(buffer, 0, buffer, new CompletionHandler<Integer, ByteBuffer>() {
                @Override
                public void completed(Integer result, ByteBuffer attachment) {
                    logger.info("Result: [{}]", result);
                    attachment.flip();
                    byte[] data = new byte[attachment.limit()];
                    attachment.get(data);
                    logger.info(new String(data));
                    attachment.clear();
                }

                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {
                    exc.printStackTrace();
                }
            });

            logger.info("end...");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
