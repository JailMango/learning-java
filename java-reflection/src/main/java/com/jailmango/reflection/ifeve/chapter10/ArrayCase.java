package com.jailmango.reflection.ifeve.chapter10;

import java.lang.reflect.Array;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ArrayCase
 *
 * @author jailmango
 * @CreateDate 2019-04-22
 * @see com.jailmango.reflection.ifeve.chapter10
 * @since R9.0
 */
public class ArrayCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ArrayCase.class);

    public static void main(String[] args) throws ClassNotFoundException {
        int[] intArr = (int[]) Array.newInstance(int.class, 3);
        Array.set(intArr, 0, 0);
        Array.set(intArr, 1, 1);
        Array.set(intArr, 2, 2);
        for (int index = 0; index < intArr.length; index++) {
            logger.info("Integer Array Index: [{}], Value: [{}]", index, intArr[index]);
        }

        // 获取数组的Class对象
        // 原生类型（如：int，double等）
        Class intArrClass1 = int[].class;
        Class intArrClass2 = Class.forName("[I");
        // 普通类型
        Class stringArrClass1 = String[].class;
        Class stringArrClass2 = Class.forName("[Ljava.lang.String;");
        // 错误的方式
        // Class errIntArrClass1 = Class.forName("I");
        // Class errIntArrClass2 = Class.forName("int");

        logger.info("Is Array: [{}]", intArrClass1.isArray());

        Class componentType = intArrClass1.getComponentType();
        logger.info("Array Component Type: [{}]", componentType.getName());

        logger.info("end...");
    }
}
