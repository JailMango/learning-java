package com.jailmango.spring.framework.bean.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jailmango.spring.framework.bean.dto.ADto;
import com.jailmango.spring.framework.bean.dto.BDto;
import com.jailmango.spring.framework.bean.dto.CDto;

/**
 * BeanConfiguration - 三种方式做「初始化」和「销毁操作」
 * 1. initMethod / destroyMethod
 * 2. implements InitializingBean / DisposableBean
 * 3. @PostConstruct / @PreDestroy
 * @author he.gang33
 * @CreateDate 2019-07-03
 * @see com.jailmango.spring.framework.bean.configuration
 * @since R9.0
 */
@Configuration
public class BeanConfiguration {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(BeanConfiguration.class);

    /**
     * getA
     * 
     * @return ADto
     */
    @Bean(name = "a", initMethod = "init", destroyMethod = "destroy")
    public ADto getA() {
        logger.info("before call ADto()");
        ADto a = new ADto("A", 20, "M");
        logger.info("after call ADto()");
        return a;
    }

    /**
     * getB
     * 
     * @return BDto
     */
    @Bean(name = "b")
    public BDto getB() {
        logger.info("before call BDto()");
        BDto b = new BDto("B", 20, "M");
        logger.info("after call BDto()");
        return b;
    }

    /**
     * getC
     * 
     * @return CDto
     */
    @Bean(name = "c")
    public CDto getC() {
        logger.info("before call CDto()");
        CDto b = new CDto("C", 20, "M");
        logger.info("after call CDto()");
        return b;
    }
}
