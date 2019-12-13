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
 * @author he.gang33
 * @CreateDate 2019-04-17
 * @see com.jailmango.nio.ifeve.chapter14
 * @since R9.0
 */
public class AsynchronousFileChannelWritingCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(AsynchronousFileChannelWritingCase.class);

    /**
     * main
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        writingViaCompletionHandler();
    }

    private static void writingViaFuture() {
        logger.info("writingViaFuture...");
        Path path = Paths.get("/Users/mango/Documents/repository/github/learning/file/file-writing.log");

        try {
            AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.put("writing test...".getBytes());
            buffer.flip();

            Future<Integer> future = fileChannel.write(buffer, 0L);

            while (!future.isDone()) {

            }

            logger.info("end...");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writingViaCompletionHandler() {
        logger.info("writingViaCompletionHandler...");
        Path path = Paths.get("/Users/mango/Documents/repository/github/learning/file/file-writing.log");

        try {
            AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.put("writing test...".getBytes());
            buffer.flip();

            fileChannel.write(buffer, 0L, buffer, new CompletionHandler<Integer, ByteBuffer>() {
                @Override
                public void completed(Integer result, ByteBuffer attachment) {
                    System.out.println("bytes written: " + result);
                }

                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {
                    exc.printStackTrace();
                }
            });
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
