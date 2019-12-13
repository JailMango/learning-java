package com.jailmango.concurrence.book.core.spring;

import javax.annotation.Resource;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * MainCase
 *
 * @author he.gang33
 * @CreateDate 2018-11-23
 * @see com.jailmango.java.book.core.spring
 * @since R9.0<br>
 */
@SpringBootApplication(scanBasePackages = {
    "com.eason.java.book.core.spring"
})
@EnableAsync
public class MainCase implements ApplicationRunner {

    /**
     * SpringRunnable
     */
    @Resource
    private SpringRunnable myRunnable;

    /**
     * main
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        SpringApplication.run(MainCase.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        for (int i = 0; i < 2; i++) {
            myRunnable.doJob();
        }
    }
}
