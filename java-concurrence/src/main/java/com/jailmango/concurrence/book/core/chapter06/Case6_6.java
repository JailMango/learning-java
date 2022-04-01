package com.jailmango.concurrence.book.core.chapter06;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 6.6 使用Enum枚举类型实现单例模式
 *
 * @author jailmango
 * @CreateDate 2020/8/31
 * @see com.jailmango.concurrence.book.core.chapter06
 * @since R9.0
 */
public class Case6_6 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case6_6.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i < 5; i++) {
                logger.info("{}", MyObject.userFactory.getUserInfo().hashCode());
            }
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        Thread thread4 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

    private static enum MyObject {

        userFactory;

        private UserInfo userInfo;

        private MyObject() {
            logger.info("调用MyObject构造函数");
            String name = "Hello-World";
            userInfo = new UserInfo();
            userInfo.setUserName(name);

        }

        public UserInfo getUserInfo() {
            return userInfo;
        }
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
