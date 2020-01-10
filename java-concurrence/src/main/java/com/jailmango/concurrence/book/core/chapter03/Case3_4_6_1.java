package com.jailmango.concurrence.book.core.chapter03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case3_4_6_1 - 3.4.6 子线程可以感应对象属性值的变化
 *
 * @author he.gang33
 * @CreateDate 2019/12/26
 * @see com.jailmango.concurrence.book.core.chapter03
 * @since R9.0
 */
public class Case3_4_6_1 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case3_4_6_1.class);

    public static void main(String[] args) throws InterruptedException {
        UserInfo userInfo = new UserInfo();
        logger.info("Main -> User[]", userInfo.hashCode());
        userInfo.setUserName("name-old");

        if (null == Data.tl.get()) {
            Data.tl.set(userInfo);
            logger.info("Main线程设置了User...");
        }

        logger.info("Main -> User[{}]-{}", Data.tl.get().hashCode(), Data.tl.get().getUserName());
        Thread.sleep(100);

        ThreadA a = new ThreadA();
        a.start();
        Thread.sleep(5000);
        // 这里直接更改了对象的属性，而非指定新的对象 在本例中，由于父线程和子线程使用的是同一个对象，因此子线程会受到影响
        Data.tl.get().setUserName("name-new");
        logger.info("Main线程设置了User...new");
    }

    private static class ThreadA extends Thread {

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    UserInfo userInfo = Data.tl.get();
                    logger.info("Thread A -> User[{}]-{}", userInfo.hashCode(), userInfo.getUserName());
                    Thread.sleep(1000);
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class Data {

        /**
         * InheritableThreadLocal
         */
        public static InheritableThreadLocal<UserInfo> tl = new InheritableThreadLocal<>();
    }

    private static class UserInfo {

        /**
         * userName
         */
        private String userName;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
}
