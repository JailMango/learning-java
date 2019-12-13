package com.jailmango.spring.framework.bean.dto;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * CDto
 *
 * @author he.gang33
 * @CreateDate 2019-07-03
 * @see com.jailmango.spring.framework.bean.dto
 * @since R9.0
 */
public class CDto {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(CDto.class);

    /**
     * name
     */
    private String name;

    /**
     * age
     */
    private int age;

    /**
     * sex
     */
    private String sex;

    /**
     * Constructor
     *
     * @param name String
     * @param age int
     * @param sex String
     */
    public CDto(String name, int age, String sex) {
        logger.info("CDto.constructor()...");
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    /**
     * postConstruct
     */
    @PostConstruct
    public void postConstruct() {
        logger.info("CDto.init()...");
    }

    /**
     * PreDestroy
     */
    @PreDestroy
    public void destroy() {
        logger.info("CDto.destroy()...");
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
