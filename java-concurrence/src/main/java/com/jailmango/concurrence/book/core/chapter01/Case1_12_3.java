package com.jailmango.concurrence.book.core.chapter01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case1_12_3 - 1.12.3 suspend() resume()缺点：数据不完整
 *
 * @author jailmango
 * @CreateDate 2019-05-22
 * @see com.jailmango.concurrence.book.core.chapter01
 * @since R9.0
 */
public class Case1_12_3 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case1_12_3.class);

    public static void main(String[] args) throws InterruptedException {
        ShareObject obj = new ShareObject();

        Thread threadA = new Thread("Thread-A") {
            @Override
            public void run() {
                obj.setValue("1", "11");
            }
        };
        threadA.start();
        Thread.sleep(100);

        Thread threadB = new Thread("Thread-B") {
            @Override
            public void run() {
                obj.printMsg();
            }
        };

        // 线程A是进行赋值操作，由于执行到一半时，线程A被暂停，未完成对password的赋值操作。因此线程B获取的时候，数据异常。
        threadB.start();
    }

    static class ShareObject {

        /**
         * username
         */
        private String username = "a";

        /**
         * password
         */
        private String password = "aa";

        /**
         * setValue
         * 
         * @param username String
         * @param password String
         */
        public void setValue(String username, String password) {
            this.username = username;
            logger.info("Thread[{}] - set username[{}]", Thread.currentThread().getName(), username);

            if ("Thread-A".equals(Thread.currentThread().getName())) {
                logger.info("Thread-A suspend...");
                Thread.currentThread().suspend();
            }

            this.password = password;
            logger.info("Thread[{}] - set password[{}]", Thread.currentThread().getName(), password);
        }

        /**
         * printMsg
         */
        public void printMsg() {
            logger.info("Thread[{}] - Username: [{}], Password: [{}]", Thread.currentThread().getName(), this.username,
                this.password);
        }
    }

}
