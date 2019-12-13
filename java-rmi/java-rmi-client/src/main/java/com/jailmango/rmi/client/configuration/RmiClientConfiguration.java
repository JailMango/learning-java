package com.jailmango.rmi.client.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import com.jailmango.rmi.service.IUserService;

/**
 * RmiClientConfiguration
 *
 * @author he.gang33
 * @CreateDate 2019-07-04
 * @see com.jailmango.rmi.client.configuration
 * @since R9.0
 */
@Configuration
public class RmiClientConfiguration {

    @Bean("userService")
    public RmiProxyFactoryBean userServiceRmiProxyFactoryBean() {
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceUrl("rmi://127.0.0.1:8888/userService");
        rmiProxyFactoryBean.setServiceInterface(IUserService.class);

        return rmiProxyFactoryBean;
    }
}
