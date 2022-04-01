package com.jailmango.nio.ifeve.chapter04;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ScatteringReads
 *
 * @author jailmango
 * @CreateDate 2019-04-03
 * @see com.jailmango.nio.ifeve.chapter04
 * @since R9.0
 */
public class ScatteringReads {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ScatteringReads.class);

    /**
     * main
     * 
     * @param args String[]
     * @throws IOException IOException
     */
    public static void main(String[] args) throws IOException {
        logger.info("start...");

        ByteBuffer header = ByteBuffer.allocate(10);
        ByteBuffer body = ByteBuffer.allocate(15);
        ByteBuffer[] bufferArray = {
            header, body
        };

        RandomAccessFile file = new RandomAccessFile(
            "/Users/mango/Documents/repository/github/learning/file/scatterring-reads-data.txt", "rw");

        /*
         * 注意buffer首先被插入到数组，然后再将数组作为channel.read()
         * 的输入参数。read()方法按照buffer在数组中的顺序将从channel中读取的数据写入到buffer，当一个buffer被写满后，channel紧接着向另一个buffer中写。 Scattering
         * Reads在移动下一个buffer前，必须填满当前的buffer，这也意味着它不适用于动态消息(译者注：消息大小不固定)。换句话说，如果存在消息头和消息体，消息头必须完成填充（例如
         * 128byte），Scattering Reads才能正常工作。
         */

        long byteRead = file.getChannel().read(bufferArray);

        logger.info("end...");
    }
}
