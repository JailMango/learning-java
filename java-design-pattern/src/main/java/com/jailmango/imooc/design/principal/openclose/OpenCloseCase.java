package com.jailmango.imooc.design.principal.openclose;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * OpenCloseCase - 开闭原则
 *
 * @author jailmango
 * @CreateDate 2019-02-27
 * @see com.jailmango.imooc.design.principal.openclose
 * @since R9.0
 */
public class OpenCloseCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(OpenCloseCase.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        ICourse javaCourse = new JavaDiscountCourse(1, "Java Enterprise Application", 348.0);
        logger.info("Name:[" + javaCourse.getName() + "], Price:[" + javaCourse.getPrice() + "]");
    }
}
