package com.jailmango.reflection.ifeve.chapter04;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jailmango.reflection.ifeve.dto.PersonDto;

/**
 * FieldCase
 *
 * @author jailmango
 * @CreateDate 2019-04-18
 * @see com.jailmango.reflection.ifeve.chapter04
 * @since R9.0
 */
public class FieldCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(FieldCase.class);

    /**
     * main
     * 
     * @param args String[]
     * @throws NoSuchFieldException NoSuchFieldException
     * @throws IllegalAccessException IllegalAccessException
     */
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Class clazz = PersonDto.class;

        // 获取Field对象，仅返回public的field
        Field[] fields = clazz.getFields();
        // 获取指定的Field
        Field field = clazz.getField("name");

        // 获取Field名称、类型
        String fieldName = field.getName();
        Class fieldType = field.getType();
        logger.info("Field Name: [{}], Type: [{}]", fieldName, fieldType);

        // 设置、获取Field的值
        PersonDto person = new PersonDto("HG", 20);
        field.set(person, "HG-MOD");

        logger.info("end...");
    }
}
