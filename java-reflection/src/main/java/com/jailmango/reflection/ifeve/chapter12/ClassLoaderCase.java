package com.jailmango.reflection.ifeve.chapter12;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ClassLoaderCase
 *
 * @author he.gang33
 * @CreateDate 2019-04-22
 * @see com.jailmango.reflection.ifeve.chapter12
 * @since R9.0
 */
public class ClassLoaderCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ClassLoaderCase.class);

    public static void main(String[] args) throws ClassNotFoundException {
        // 动态加载一个类
        ClassLoader classLoader = ClassLoaderCase.class.getClassLoader();
        Class clazz = classLoader.loadClass("com.jailmango.reflection.ifeve.chapter12.AnotherClass");
        logger.info("Load Class: [{}]", clazz.getName());

        Class clazz1 = classLoader.loadClass("com.jailmango.reflection.ifeve.chapter12.AnotherClass");
        logger.info("Load Class: [{}]", clazz1.getName());

    }
}
