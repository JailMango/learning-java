package com.jailmango.nio.ifeve.chapter11;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * PipeCase
 *
 * @author he.gang33
 * @CreateDate 2019-04-10
 * @see com.jailmango.nio.ifeve.chapter11
 * @since R9.0
 */
public class PipeCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(PipeCase.class);

    /**
     * main
     * 
     * @param args String[]
     * @throws IOException IOException
     */
    public static void main(String[] args) throws IOException {
        // 创建Pipe
        Pipe pipe = Pipe.open();

        // 获取Sink通道，用于写数据
        Pipe.SinkChannel sinkChannel = pipe.sink();

        String msg = "Now: [" + System.currentTimeMillis() + "]";
        ByteBuffer writeBuffer = ByteBuffer.allocate(20);
        writeBuffer.clear();
        writeBuffer.put(msg.getBytes(StandardCharsets.UTF_8));
        writeBuffer.flip();

        while (writeBuffer.hasRemaining()) {
            sinkChannel.write(writeBuffer);
        }

        // 获取Source通道，用于读数据
        Pipe.SourceChannel sourceChannel = pipe.source();

        ByteBuffer readBuffer = ByteBuffer.allocate(20);
        int readByte = sourceChannel.read(readBuffer);

        if (readByte > 0) {
            readBuffer.flip();
            logger.info("read from pipe: [" + new String(readBuffer.array(), StandardCharsets.UTF_8) + "]");
        }

    }
}
