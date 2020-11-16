package com.jailmango.concurrence.book.action.chapter05;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import lombok.extern.slf4j.Slf4j;

/**
 * C5_11_1_AIO_Server
 *
 * @author he.gang33
 * @CreateDate 2020/11/5
 * @see com.jailmango.concurrence.book.action.chapter05
 * @since R9.0
 */
@Slf4j
public class C5_11_1_AIO_Server {

    private static final int PORT = 8000;

    // server
    private AsynchronousServerSocketChannel asynchronousServerSocketChannel;

    public C5_11_1_AIO_Server() throws IOException {
        asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open().bind(new InetSocketAddress(PORT));
    }

    public void start() {
        log.info("Server listen on {}...", PORT);
        asynchronousServerSocketChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {

            final ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

            @Override
            public void completed(AsynchronousSocketChannel result, Object attachment) {
                log.info("Completed...");
                Future<Integer> writeResult = null;

                try {
                    byteBuffer.clear();
                    result.read(byteBuffer).get(100, TimeUnit.SECONDS);
                    byteBuffer.flip();
                    writeResult = result.write(byteBuffer);
                }
                catch (InterruptedException | ExecutionException | TimeoutException e) {
                    log.warn("failed to complete...");
                    e.printStackTrace();
                }
                finally {
                    asynchronousServerSocketChannel.accept(null, this);
                    try {
                        writeResult.get();
                        result.close();
                    }
                    catch (InterruptedException | ExecutionException | IOException e) {
                        log.warn("catch exception in finnaly...");
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                log.warn("failed...[{}]", exc);
            }
        });
    }

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        new C5_11_1_AIO_Server().start();

        while (true) {
            Thread.sleep(1000);
        }
    }
}
