package com.jailmango.concurrence.book.action.chapter05;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * C5_11_2_AIO_Client
 *
 * @author he.gang33
 * @CreateDate 2020/11/5
 * @see com.jailmango.concurrence.book.action.chapter05
 * @since R9.0
 */
@Slf4j
public class C5_11_2_AIO_Client {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        // client
        final AsynchronousSocketChannel asynchronousSocketChannel = AsynchronousSocketChannel.open();
        asynchronousSocketChannel.connect(new InetSocketAddress("localhost", 8000), null,
            new CompletionHandler<Void, Object>() {
                @Override
                public void completed(Void result, Object attachment) {
                    log.info("in connect completed...");

                    asynchronousSocketChannel.write(ByteBuffer.wrap("Hello!".getBytes()), null,
                        new CompletionHandler<Integer, Object>() {
                            @Override
                            public void completed(Integer result, Object attachment) {
                                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                                asynchronousSocketChannel.read(byteBuffer, byteBuffer,
                                    new CompletionHandler<Integer, ByteBuffer>() {
                                        @Override
                                        public void completed(Integer result, ByteBuffer attachment) {
                                            log.info("in read completed...");
                                            byteBuffer.flip();
                                            log.info("read [{}]", new String(byteBuffer.array()));

                                            try {
                                                asynchronousSocketChannel.close();
                                            }
                                            catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                        }

                                        @Override
                                        public void failed(Throwable exc, ByteBuffer attachment) {
                                            log.warn("failed in read...[{}]", exc);
                                        }
                                    });
                            }

                            @Override
                            public void failed(Throwable exc, Object attachment) {
                                log.warn("failed in write...[{}]", exc);
                            }
                        });
                }

                @Override
                public void failed(Throwable exc, Object attachment) {
                    log.warn("failed in connect...[{}]", exc);
                }
            });

        Thread.sleep(1000);
    }
}
