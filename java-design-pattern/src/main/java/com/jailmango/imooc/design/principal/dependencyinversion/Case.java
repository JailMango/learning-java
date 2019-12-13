package com.jailmango.imooc.design.principal.dependencyinversion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case - 依赖倒置原则
 *
 * @author he.gang33
 * @CreateDate 2019-02-27
 * @see com.jailmango.imooc.design.principal.dependencyinversion
 * @since R9.0
 */
public class Case {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case.class);

    // V1.0
    // public static void main(String[] args) {
    // JailMango ins = new JailMango();
    // ins.studyJava();
    // ins.studyJavaScript();
    // }

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        JailMango ins = new JailMango();

        ICourse javaCourse = new JavaCourse();
        ins.setCourse(javaCourse);
        ins.study();

        ICourse pythonCourse = new PythonCourse();
        ins.setCourse(pythonCourse);
        ins.study();
    }

}
