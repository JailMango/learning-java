package com.jailmango.reflection.ifeve.chapter09;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jailmango.reflection.ifeve.dto.GenericsDto;

/**
 * GenericsCase - 泛型
 *
 * @author jailmango
 * @CreateDate 2019-04-19
 * @see com.jailmango.reflection.ifeve.chapter09
 * @since R9.0
 */
public class GenericsCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(GenericsCase.class);

    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException {
        Class clazz = GenericsDto.class;

        // 泛型方法返回类型
        Method getMethod = clazz.getMethod("getList");
        logger.info("Method: [{}]", getMethod.getName());

        Class returnType = getMethod.getReturnType();
        logger.info("Return Type: [{}]", returnType.getName());

        Type genericReturnType = getMethod.getGenericReturnType();
        logger.info("Generic Return Type: [{}]", genericReturnType.getTypeName());
        if (genericReturnType instanceof ParameterizedType) {
            ParameterizedType type = (ParameterizedType) genericReturnType;
            Type[] types = type.getActualTypeArguments();
            for (Type item : types) {
                logger.info("Parameterized Return Type: [{}]", item.getTypeName());
            }
        }

        // 泛型方法参数类型
        Method setMethod = clazz.getMethod("setList", List.class);
        logger.info("Method Name: [{}]", setMethod.getName());

        Class[] parameterTypes = setMethod.getParameterTypes();
        for (Class parameterType : parameterTypes) {
            logger.info("Parameter Type: [{}]", parameterType.getName());
        }

        Type[] genericParameterTypes = setMethod.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes) {
            logger.info("Generic Parameter Type: [{}]", genericParameterType.getTypeName());

            if (genericParameterType instanceof ParameterizedType) {
                ParameterizedType parameterizedTypes = (ParameterizedType) genericParameterType;
                Type[] types = parameterizedTypes.getActualTypeArguments();
                for (Type type : types) {
                    logger.info("Parameterized Parameter Type: [{}]", type.getTypeName());
                }
            }
        }

        // 泛型变量类型
        Field field = clazz.getField("list");
        logger.info("Field Type: [{}]", field.getType().getName());
        Type fieldGenericType = field.getGenericType();
        logger.info("Field Generic Type: [{}]", fieldGenericType.getTypeName());
        if (fieldGenericType instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) fieldGenericType;
            Type[] types = parameterizedType.getActualTypeArguments();
            for (Type type : types) {
                logger.info("Parameterized Field Type: [{}]", type.getTypeName());
            }
        }

        logger.info("end...");
    }

}
