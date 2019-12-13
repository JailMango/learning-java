package com.jailmango.spring.framework.bean.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * BDto
 *
 * @author he.gang33
 * @CreateDate 2019-07-03
 * @see com.jailmango.spring.framework.bean.dto
 * @since R9.0
 */
public class BDto implements InitializingBean, DisposableBean {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(BDto.class);

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
    public BDto(String name, int age, String sex) {
        logger.info("BDto.constructor()...");
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("BDto.init()...");
    }

    @Override
    public void destroy() throws Exception {
        logger.info("BDto.destroy()...");
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
