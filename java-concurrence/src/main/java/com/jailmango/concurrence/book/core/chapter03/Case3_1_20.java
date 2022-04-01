package com.jailmango.concurrence.book.core.chapter03;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case3_1_20 - 3.1.20 通过管道进行线程间通信 - 字节流
 *
 * @author jailmango
 * @CreateDate 2019-06-04
 * @see com.jailmango.concurrence.book.core.chapter03
 * @since R9.0
 */
public class Case3_1_20 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case3_1_20.class);

    public static void main(String[] args) {

        try {
            WriteService ws = new WriteService();
            ReadService rs = new ReadService();

            PipedInputStream pis = new PipedInputStream();
            PipedOutputStream pos = new PipedOutputStream();

            // connect()方法，使两个管道之间建立通信连接
            pis.connect(pos);

            ReadThread rt = new ReadThread("Thread=Read", rs, pis);
            rt.start();
            Thread.sleep(100);
            WriteThread wt = new WriteThread("Thread-Write", ws, pos);
            wt.start();

        }
        catch (IOException e) {
            logger.error(e.getLocalizedMessage());
        }
        catch (InterruptedException e) {
            logger.error(e.getLocalizedMessage());
        }

    }

    static class WriteThread extends Thread {

        private WriteService service;

        private PipedOutputStream pos;

        public WriteThread(String name, WriteService service, PipedOutputStream pos) {
            super(name);
            this.service = service;
            this.pos = pos;
        }

        @Override
        public void run() {
            service.write(pos);
        }
    }

    static class ReadThread extends Thread {

        private ReadService service;

        private PipedInputStream pis;

        public ReadThread(String name, ReadService service, PipedInputStream pis) {
            super(name);
            this.service = service;
            this.pis = pis;
        }

        @Override
        public void run() {
            service.read(pis);
        }
    }

    static class WriteService {

        public void write(PipedOutputStream pos) {
            try {
                for (int i = 0; i < 50; i++) {
                    String data = "" + (i + 1);
                    pos.write(data.getBytes());
                    logger.info("Thread[{}] write [{}]", Thread.currentThread().getName(), data);
                    Thread.sleep(100);
                }

                pos.close();
            }
            catch (IOException e) {
                logger.error(e.getLocalizedMessage());
            }
            catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }
        }
    }

    static class ReadService {

        public void read(PipedInputStream pis) {
            try {
                byte[] byteArray = new byte[20];

                // 若一开始无写入线程，则此处会阻塞
                int readLength = pis.read(byteArray);

                while (readLength != -1) {
                    String data = new String(byteArray, 0, readLength);
                    logger.info("Thread[{}] read [{}]", Thread.currentThread().getName(), data);
                    readLength = pis.read(byteArray);
                }

                pis.close();
            }
            catch (IOException e) {
                logger.error(e.getLocalizedMessage());
            }
        }
    }
}
