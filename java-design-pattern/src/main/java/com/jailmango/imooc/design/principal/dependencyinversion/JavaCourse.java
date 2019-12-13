package com.jailmango.imooc.design.principal.dependencyinversion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JavaCourse
 *
 * @author he.gang33
 * @CreateDate 2019-02-27
 * @see com.jailmango.imooc.design.principal.dependencyinversion
 * @since R9.0
 */
public class JavaCourse implements ICourse {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(JavaCourse.class);

    @Override
    public void study() {
        logger.info("study java...");
    }
}
