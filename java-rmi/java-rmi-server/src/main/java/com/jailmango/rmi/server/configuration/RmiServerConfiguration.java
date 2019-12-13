package com.jailmango.rmi.server.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

import com.jailmango.rmi.service.IUserService;

/**
 * RmiServerConfiguration
 *
 * @author he.gang33
 * @CreateDate 2019-07-04
 * @see com.jailmango.rmi.server.configuration
 * @since R9.0
 */
@Configuration
public class RmiServerConfiguration {

    /**
     * userService
     */
    @Autowired
    private IUserService userService;

    /**
     * rmiUserServiceExporter
     * 
     * @return RmiServiceExporter
     */
    @Bean("rmiUserServiceExporter")
    public RmiServiceExporter rmiUserServiceExporter() {
        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setRegistryPort(8888);
        exporter.setServiceName("userService");
        exporter.setService(userService);
        exporter.setServiceInterface(IUserService.class);

        return exporter;
    }

}
