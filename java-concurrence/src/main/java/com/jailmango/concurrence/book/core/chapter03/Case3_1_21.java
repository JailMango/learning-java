package com.jailmango.concurrence.book.core.chapter03;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case3_1_21 - 3.1.21 通过管道进行线程间通信 - 字符流
 *
 * @author jailmango
 * @CreateDate 2019-06-04
 * @see com.jailmango.concurrence.book.core.chapter03
 * @since R9.0
 */
public class Case3_1_21 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case3_1_21.class);

    public static void main(String[] args) {
        try {
            WriteService ws = new WriteService();
            ReadService rs = new ReadService();

            PipedWriter pw = new PipedWriter();
            PipedReader pr = new PipedReader();

            pw.connect(pr);

            ReadThread rt = new ReadThread("Thread-Read", rs, pr);
            rt.start();

            WriteThread wt = new WriteThread("Thread-Write", ws, pw);
            wt.start();

            // 大体流程和理解，基本同Case3_1_20
        }
        catch (IOException e) {
            logger.error(e.getLocalizedMessage());
        }

    }

    static class WriteThread extends Thread {

        private WriteService service;

        private PipedWriter pw;

        public WriteThread(String name, WriteService service, PipedWriter pw) {
            super(name);
            this.service = service;
            this.pw = pw;
        }

        @Override
        public void run() {
            service.write(pw);
        }
    }

    static class ReadThread extends Thread {

        private ReadService service;

        private PipedReader pr;

        public ReadThread(String name, ReadService service, PipedReader pr) {
            super(name);
            this.service = service;
            this.pr = pr;
        }

        @Override
        public void run() {
            service.read(pr);
        }
    }

    static class WriteService {

        public void write(PipedWriter pw) {
            try {
                for (int i = 0; i < 50; i++) {
                    String data = "" + (i + 1);
                    pw.write(data);
                    logger.info("Thread[{}] write [{}]", Thread.currentThread().getName(), data);
                    Thread.sleep(200);
                }
                pw.close();
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

        public void read(PipedReader pr) {
            try {
                char[] charArray = new char[20];
                int readLength = pr.read(charArray);

                while (readLength != -1) {
                    String data = new String(charArray, 0, readLength);
                    logger.info("Thread[{}] read [{}]", Thread.currentThread().getName(), data);
                    readLength = pr.read(charArray);
                }

                pr.close();
            }
            catch (IOException e) {
                logger.error(e.getLocalizedMessage());
            }
        }
    }
}
