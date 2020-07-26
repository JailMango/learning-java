package com.jailmango.exercise.utils.extendscase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main
 *
 * @author he.gang33
 * @CreateDate 2020/7/16
 * @see com.jailmango.exercise.utils.extendscase
 * @since R9.0
 */
public class Main {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        InheritDto inheritDto = new InheritDto();
        logger.info("name: [{}]", inheritDto.getName());

        inheritDto.setName("inherit");
        logger.info("name: [{}]", inheritDto.getName());
    }
}
