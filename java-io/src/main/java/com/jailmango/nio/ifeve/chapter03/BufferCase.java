package com.jailmango.nio.ifeve.chapter03;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * BufferCase
 *
 * @author he.gang33
 * @CreateDate 2019-03-25
 * @see com.jailmango.nio.ifeve.chapter03
 * @since R9.0
 */
public class BufferCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(BufferCase.class);

    /**
     * log template
     */
    private static final String LOG_TEMPLATE = "Position: [{}], Content: [{}], Limit: [{}]";

    /**
     * 分隔符
     */
    private static final String SPLIT_SYMBOL = "==========================================";

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
        // read into buffer.
        int byteRead = channel.read(buffer);
        // // put into buffer.
        // buffer.put((byte) 127);

        logger.info("Read " + byteRead);

        while (-1 != byteRead) {
            // 注意 buf.flip() 的调用，首先读取数据到Buffer，然后反转Buffer,接着再从Buffer中读取数据。
            buffer.flip();

            readData(buffer);
            logger.info(SPLIT_SYMBOL);

            rewind(buffer);
            readData(buffer);
            logger.info(SPLIT_SYMBOL);

            rewind(buffer);
            clear(buffer);
            // 调用clear方法后, 未写入新数据, 直接重读buffer, buffer数据与原先保持一致
            readData(buffer);
            logger.info(SPLIT_SYMBOL);

            rewind(buffer);
            compact(buffer);
            readData(buffer);
            logger.info(SPLIT_SYMBOL);

            markAndRest(buffer);
            logger.info(SPLIT_SYMBOL);

            // make buffer ready for writing
            buffer.clear();
            byteRead = channel.read(buffer);
        }

        file.close();
    }

    /**
     * markAndReset
     * 
     * @param buffer ByteBuffer
     */
    private static void markAndRest(ByteBuffer buffer) {
        logger.info("buffer.mark() & reset() - start...");
        logger.info("buffer.mark() - start...");

        while (buffer.hasRemaining()) {
            // read 1 byte at a time
            logger.info(LOG_TEMPLATE, buffer.position(), buffer.get(), buffer.limit());

            if (2 == buffer.position()) {
                // 通过调用Buffer.mark()方法，可以标记Buffer中的一个特定position
                buffer.mark();
            }
        }

        logger.info("buffer.mark() - end...");

        logger.info("buffer.reset() - start...");
        // 通过调用Buffer.reset()方法恢复到之前mark的position
        buffer.reset();
        readData(buffer);
        logger.info("buffer.reset() - end...");

        logger.info("buffer.mark() & reset() - end...");
    }

    /**
     * compact
     * 
     * @param buffer ByteBuffer
     */
    private static void compact(ByteBuffer buffer) {
        logger.info("buffer.compact() - start...");

        while (buffer.hasRemaining()) {
            // read 1 byte at a time
            logger.info(LOG_TEMPLATE, buffer.position(), buffer.get(), buffer.limit());

            if (5 == buffer.position()) {
                // compact()方法将所有未读的数据拷贝到Buffer起始处。然后将position设到最后一个未读元素正后面。limit属性依然像clear()方法一样，设置成capacity
                buffer.compact();
                logger.info("break loop...");
                break;
            }
        }
        readData(buffer);
        logger.info("buffer.compact() - end...");
    }

    /**
     * clear
     * 
     * @param buffer ByteBuffer
     */
    private static void clear(ByteBuffer buffer) {
        logger.info("buffer.clear() - start...");

        while (buffer.hasRemaining()) {
            // read 1 byte at a time
            logger.info(LOG_TEMPLATE, buffer.position(), buffer.get(), buffer.limit());

            if (5 == buffer.position()) {
                // position将被设回0，limit被设置成capacity的值
                buffer.clear();
                logger.info("break loop...");
                break;
            }
        }
    }

    /**
     * read
     * 
     * @param buffer ByteBuffer
     */
    private static void rewind(ByteBuffer buffer) {
        logger.info("buffer.rewind() - start...");
        // 将position设回为0，limit保持不变，仍然表示能从Buffer中读取多少个元素，即可以重读buffer中的所有数据
        buffer.rewind();
        logger.info("buffer.rewind() - end...");
    }

    /**
     * 读取数据
     * 
     * @param buffer read
     */
    private static void readData(ByteBuffer buffer) {
        logger.info("read data - start...");
        // 访问buffer中的数据
        while (buffer.hasRemaining()) {
            // read 1 byte at a time
            logger.info(LOG_TEMPLATE, buffer.position(), buffer.get(), buffer.limit());
        }
        logger.info("no data in buffer...");
        logger.info("read data - end...");
    }

}
