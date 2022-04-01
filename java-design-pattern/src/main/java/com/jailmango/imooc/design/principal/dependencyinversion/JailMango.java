package com.jailmango.imooc.design.principal.dependencyinversion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JailMango
 *
 * @author jailmango
 * @CreateDate 2019-02-27
 * @see com.jailmango.imooc.design.principal.dependencyinversion
 * @since R9.0
 */
public class JailMango {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(JailMango.class);

    private ICourse course;

    public void studyJava() {
        logger.info("study java...");
    }

    public void studyJavaScript() {
        logger.info("study javascript...");
    }

    public void study(ICourse course) {
        course.study();
    }

    public void study() {
        getCourse().study();
    }

    public ICourse getCourse() {
        return course;
    }

    public void setCourse(ICourse course) {
        this.course = course;
    }
}
