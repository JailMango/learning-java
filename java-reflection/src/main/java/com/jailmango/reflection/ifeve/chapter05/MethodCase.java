package com.jailmango.reflection.ifeve.chapter05;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jailmango.reflection.ifeve.dto.PersonDto;

/**
 * MethodCase
 *
 * @author jailmango
 * @CreateDate 2019-04-18
 * @see com.jailmango.reflection.ifeve.chapter05
 * @since R9.0
 */
public class MethodCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(MethodCase.class);

    /**
     * main
     * 
     * @param args String[]
     * @throws NoSuchMethodException NoSuchMethodException
     * @throws InvocationTargetException InvocationTargetException
     * @throws IllegalAccessException IllegalAccessException
     */
    public static void main(String[] args)
        throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class clazz = PersonDto.class;

        // 获取Method对象，仅返回public的method
        Method[] methods = clazz.getMethods();
        // Method method = clazz.getMethod("getInfo", null);
        Method method = clazz.getMethod("setName", String.class);

        // 方法参数及返回类型
        Class returnType = method.getReturnType();
        logger.info("Method: [{}], Return Type: [{}]", method.getName(), returnType.getName());

        Parameter[] parameters = method.getParameters();
        for (Parameter parameter : parameters) {
            logger.info("Parameter Name: [{}], Parameter Type: [{}]", parameter.getName(),
                parameter.getType().getName());
        }

        Class[] parameterTypes = method.getParameterTypes();

        // 通过Method对象调用方法
        PersonDto person = new PersonDto("invoke", 1);
        method.invoke(person, "invoke-mod");

        String info = (String) clazz.getMethod("getInfo").invoke(person);
        logger.info(info);
    }
}
