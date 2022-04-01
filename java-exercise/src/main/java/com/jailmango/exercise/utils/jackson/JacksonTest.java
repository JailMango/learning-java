package com.jailmango.exercise.utils.jackson;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * JacksonTest
 *
 * @author jailmango
 * @CreateDate 2018-11-26
 * @see com.jailmango.exercise.utils.jackson
 * @since R9.0<br>
 */
public class JacksonTest {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(JacksonTest.class);

    /**
     * main
     * 
     * @param args String[]
     * @throws IOException IOException
     */
    public static void main(String[] args) throws IOException {
        String jsonStr = "{\"name\":\"Mahesh\", \"age\":21}";
        ObjectMapper objectMapper = new ObjectMapper();

        Student student = objectMapper.readValue(jsonStr, Student.class);
        logger.info(student.toString());

        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String jacksonStr = objectMapper.writeValueAsString(student);
        logger.info(jacksonStr);
    }
}

class Student {

    /**
     * name
     */
    private String name;

    /**
     * age
     */
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

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}
