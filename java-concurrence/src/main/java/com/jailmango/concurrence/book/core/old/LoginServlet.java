package com.jailmango.concurrence.book.core.old;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * LoginServlet - 模拟非线程安全环境
 *
 * @author jailmango
 * @CreateDate 2018/11/17
 * @see com.jailmango.java.book.core.chapter01
 * @since R9.0<br>
 */
public class LoginServlet {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(LoginServlet.class);

    /**
     * userNameRef
     */
    private static String userNameRef;

    /**
     * passwordRef
     */
    private static String passwordRef;

    /**
     * doPost
     * 
     * @param userName String
     * @param password String
     * @throws InterruptedException InterruptedException
     */
    public static synchronized void doPost(String userName, String password) throws InterruptedException {
        userNameRef = userName;

        if ("a".equals(userNameRef)) {
            Thread.sleep(5000);
        }

        passwordRef = password;

        logger.info("UserName:[" + userNameRef + "], Password:[" + passwordRef + "]");
    }
}
