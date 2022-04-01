package com.jailmango.imooc.design.principal.dependencyinversion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * PythonCourse
 *
 * @author jailmango
 * @CreateDate 2019-02-27
 * @see com.jailmango.imooc.design.principal.dependencyinversion
 * @since R9.0
 */
public class PythonCourse implements ICourse {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(PythonCourse.class);

    @Override
    public void study() {
        logger.info("study python...");
    }
}
