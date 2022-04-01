package com.jailmango.concurrence.book.action.chapter05;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import lombok.extern.slf4j.Slf4j;

/**
 * C5_5_5_并行流水线
 *
 * @author jailmango
 * @CreateDate 2020/10/26
 * @see com.jailmango.concurrence.book.action.chapter05
 * @since R9.0
 */
@Slf4j
public class C5_5_5_并行流水线 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Plus()).start();
        new Thread(new Multiply()).start();
        new Thread(new Div()).start();

        for (int i = 1; i < 2; i++) {
            for (int j = 1; j < 2; j++) {
                Msg message = new Msg();
                message.i = i;
                message.j = j;
                Plus.queue.put(message);
            }
        }
    }

    private static class Plus implements Runnable {

        public static BlockingQueue<Msg> queue = new LinkedBlockingQueue<>();

        @Override
        public void run() {
            while (true) {
                try {
                    Msg message = queue.take();
                    message.j = message.i + message.j;
                    Multiply.queue.put(message);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class Multiply implements Runnable {

        public static BlockingQueue<Msg> queue = new LinkedBlockingQueue<>();

        @Override
        public void run() {
            while (true) {
                try {
                    Msg message = queue.take();
                    message.i = message.i * message.j;
                    Div.queue.put(message);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class Div implements Runnable {

        public static BlockingQueue<Msg> queue = new LinkedBlockingQueue<>();

        @Override
        public void run() {
            while (true) {
                while (true) {
                    try {
                        Msg message = queue.take();
                        message.i = message.i / 2;
                        log.info("计算结果 = {}", message.i);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static class Msg {

        public double i;

        public double j;

        public String orgStr;
    }
}
