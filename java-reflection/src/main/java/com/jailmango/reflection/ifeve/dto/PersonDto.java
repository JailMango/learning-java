package com.jailmango.reflection.ifeve.dto;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jailmango.reflection.ifeve.annotation.ReflectionAnnotation;
import com.jailmango.reflection.ifeve.intf.ReflectionInterface;

/**
 * PersonDto
 *
 * @author jailmango
 * @CreateDate 2019-04-17
 * @see com.jailmango.reflection.ifeve.dto
 * @since R9.0
 */
@ReflectionAnnotation(name = "classAnnotation")
public class PersonDto extends BaseDto implements ReflectionInterface, Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -4082478397987278164L;

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(PersonDto.class);

    /**
     * name
     */
    public String name;

    /**
     * age
     */
    @ReflectionAnnotation(name = "fieldAnnotation")
    private int age;

    /**
     * Constructor
     * 
     * @param name String
     */
    public PersonDto(String name) {
        this.name = name;
    }

    /**
     * Constructor
     * 
     * @param age int
     */
    public PersonDto(int age) {
        this.age = age;
    }

    /**
     * Constructor
     * 
     * @param name String
     * @param age int
     */
    public PersonDto(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * getInfo
     *
     * @return String
     */
    public String getInfo() {
        return "Name: [" + this.name + "], Age: [" + this.age + "]";
    }

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
    public void doSomething() {
        logger.info("doing...");
    }

    /**
     * privateDo
     * 
     * @return String
     */
    @ReflectionAnnotation(name = "methodAnnotation")
    private String privateDo() {
        String str = getInfo();
        logger.info(str);
        return str;
    }

    /**
     * annotationFunc
     * 
     * @param param1 String
     * @param param2 String
     * @param param3 String
     */
    @ReflectionAnnotation(name = "methodAnnotation")
    private void annotationFunc(@ReflectionAnnotation(name = "paramAnnotation1") String param1,
        @ReflectionAnnotation(name = "paramAnnotation2") String param2,
        @ReflectionAnnotation(name = "paramAnnotation3") String param3) {
    }
}
