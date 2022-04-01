package com.jailmango.concurrence.book.action.chapter02;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * 2.2.2 终止线程 - 反例:使用stop()方法 <br/>
 * 模拟写线程
 *
 * @author jailmango
 * @CreateDate 2020/9/16
 * @see com.jailmango.concurrence.book.corelib.chapter02
 * @since R9.0
 */
@Slf4j
public class Case2_2_2_1 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        User user = new User(0, "0");

        ReadObjectThread readThread = new ReadObjectThread("Read-Thread", user);
        readThread.start();

        int count = 0;

//        while (true) {
        for (int i = 0; i < 50; i++) {
            WriteObjectThread writeThread = new WriteObjectThread("Write-" + ++count, user);
            writeThread.start();
            Thread.sleep(150);
            writeThread.stop();
        }
    }

    private static class ReadObjectThread extends Thread {

        private User user;

        public ReadObjectThread(String name, User user) {
            super(name);
            this.user = user;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (user) {
                    if (user.getId() != Integer.parseInt(user.getName())) {
                        log.info("ID:[{}], Name:[{}]", user.getId(), user.getName());
                    }
                }
                Thread.yield();
            }
        }
    }

    private static class WriteObjectThread extends Thread {

        private User user;

        public WriteObjectThread(String name, User user) {
            super(name);
            this.user = user;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (user) {
                    int id = (int) (System.currentTimeMillis() / 10);
                    user.setId(id);
                    try {
                        Thread.sleep(100);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    user.setName(String.valueOf(id));
                }
                Thread.yield();
            }
        }
    }

    @AllArgsConstructor
    @Getter
    @Setter
    @Builder
    @ToString
    private static class User {

        private int id;

        private String name;
    }
}
