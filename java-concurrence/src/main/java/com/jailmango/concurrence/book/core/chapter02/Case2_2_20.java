package com.jailmango.concurrence.book.core.chapter02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case2_2_20 - 2.2.20 内置类与静态内置类 {@link PublicClass}
 *
 * @author he.gang33
 * @CreateDate 2019-05-29
 * @see com.jailmango.concurrence.book.core.chapter02
 * @since R9.0
 */
public class Case2_2_20 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case2_2_20.class);

    public static void main(String[] args) {
        PublicClass publicClass = new PublicClass();
        publicClass.setName("public-class");
        publicClass.setPassword("public-class-pwd");

        logger.info("Public Class - Name: [{}], Password: [{}]", publicClass.getName(), publicClass.getPassword());

        PublicClass.PrivateClass privateClass = publicClass.new PrivateClass();
        privateClass.setAge(20);
        privateClass.setAddress("private-class-addr");

        logger.info("Private Class - Age: [{}], Address: [{}]", privateClass.getAge(), privateClass.getAddress());

        PublicClass.StaticPrivateClass staticPrivateClass = new PublicClass.StaticPrivateClass();
        staticPrivateClass.setAge(20);
        staticPrivateClass.setAddress("static-private-class-addr");

        logger.info("Static Private Class - Age: [{}], Address: [{}]", staticPrivateClass.getAge(),
            staticPrivateClass.getAddress());

        // 静态内部类的实例对象不需要通过外部类的实例对象 new 出来
    }
}
