package com.jailmango.spring.application.config;

import com.jailmango.spring.application.accessor.Accessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * BizConfig
 *
 * @author jailmango
 * @CreateDate 2021/12/2
 * @see com.jailmango.spring.application.config
 */
@Configuration
public class BizConfig {

    @Bean
    public String customBiz(@Autowired Accessor accessor) {
        accessor.access();
        return "customBiz";
    }
}
