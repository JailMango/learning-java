package com.jailmango.reflection.ifeve.chapter03;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jailmango.reflection.ifeve.dto.PersonDto;

/**
 * ConstructorCase
 *
 * @author he.gang33
 * @CreateDate 2019-04-18
 * @see com.jailmango.reflection.ifeve.chapter03
 * @since R9.0
 */
public class ConstructorCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ConstructorCase.class);

    /**
     * main
     * 
     * @param args String[]
     * @throws NoSuchMethodException NoSuchMethodException
     * @throws IllegalAccessException IllegalAccessException
     * @throws InvocationTargetException InvocationTargetException
     * @throws InstantiationException InstantiationException
     */
    public static void main(String[] args)
        throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = PersonDto.class;

        // 获取所有构造方法，只可返回public方法
        Constructor[] constructors = clazz.getConstructors();
        Constructor constructor = clazz.getConstructor(String.class, int.class);

        // 获取构造方法参数
        Class[] parameterTypes = constructor.getParameterTypes();
        for (Class parameterType : parameterTypes) {
            logger.info("Parameter Type: [{}]", parameterType.getName());
        }

        // 实例化对象
        PersonDto person = (PersonDto) constructor.newInstance("HG", 26);
    }
}
