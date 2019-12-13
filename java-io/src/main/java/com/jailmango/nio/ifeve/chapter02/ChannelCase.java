package com.jailmango.nio.ifeve.chapter02;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ChannelCase
 * 
 * @author he.gang33
 * @CreateDate 2019-03-21
 * @see com.jailmango.nio.ifeve.chapter02
 * @since R9.0
 */
public class ChannelCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ChannelCase.class);

    /**
     * main
     * 
     * @param args String[]
     * @throws IOException IOException
     */
    public static void main(String[] args) throws IOException {
        /*
         * FileChannel 从文件中读写数据。 DatagramChannel 能通过UDP读写网络中的数据。 SocketChannel 能通过TCP读写网络中的数据。
         * ServerSocketChannel可以监听新进来的TCP连接，像Web服务器那样。对每一个新进来的连接都会创建一个SocketChannel。
         */

        RandomAccessFile file = new RandomAccessFile(
            "/Users/mango/Documents/repository/github/learning/file/nio-data.txt", "rw");
        FileChannel channel = file.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(256);

        int bytesRead = channel.read(buffer);

        while (-1 != bytesRead) {
            logger.info("Read " + bytesRead);
            // 注意 buf.flip() 的调用，首先读取数据到Buffer，然后反转Buffer,接着再从Buffer中读取数据。
            buffer.flip();

            while (buffer.hasRemaining()) {
                logger.info(String.valueOf(buffer.get()));
            }

            buffer.clear();
            bytesRead = channel.read(buffer);
        }

        file.close();

        logger.info("end...");
    }
}
