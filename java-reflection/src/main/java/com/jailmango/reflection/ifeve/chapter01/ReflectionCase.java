package com.jailmango.reflection.ifeve.chapter01;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jailmango.reflection.ifeve.dto.PersonDto;

/**
 * ReflectionCase
 *
 * @author he.gang33
 * @CreateDate 2019-04-17
 * @see com.jailmango.reflection.ifeve.chapter01
 * @since R9.0
 */
public class ReflectionCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ReflectionCase.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Method[] methods = PersonDto.class.getMethods();

        for (Method method : methods) {
            logger.info("Method: [{}]", method.getName());
        }
    }
}
