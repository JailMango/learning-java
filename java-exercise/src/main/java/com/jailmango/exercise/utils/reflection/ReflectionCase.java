package com.jailmango.exercise.utils.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ReflectionUtils;

/**
 * ReflectionCase
 *
 * @author jailmango
 * @CreateDate 2018-11-22
 * @see com.jailmango.exercise.utils.reflection
 * @since R9.0<br>
 */
public class ReflectionCase {

    public static void main(String[] args) {
        Method[] methods = ReflectionUtils.getAllDeclaredMethods(Person.class);

        Field[] fields = Person.class.getFields();
        int a = 1;
    }
}

class Person {
    private static final Logger logger = LoggerFactory.getLogger(Person.class);

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
