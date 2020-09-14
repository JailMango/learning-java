package com.jailmango.spring.book.principles.chapter01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 1.1. 开闭原则
 *
 * @author he.gang33
 * @CreateDate 2020/9/11
 * @see com.jailmango.spring.book.principles.chapter01
 * @since R9.0
 */
public class Case1_1_1 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case1_1_1.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        JavaCourse javaCourse = new JavaCourse(1, "Java-Course", 100.00);
        logger.info("{}'s price: {}", javaCourse.getName(), javaCourse.getPrice());

        JavaDiscountCourse javaDiscountCourse = new JavaDiscountCourse(2, "Java-Discount-Course", 100.00);
        logger.info("{}'s price: {}", javaDiscountCourse.getName(), javaDiscountCourse.getDiscountPrice());
    }

    private static interface ICourse {

        int getId();

        String getName();

        Double getPrice();
    }

    private static class JavaCourse implements ICourse {

        private int id;

        private String name;

        private Double price;

        public JavaCourse(int id, String name, Double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        @Override
        public int getId() {
            return this.id;
        }

        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public Double getPrice() {
            return this.price;
        }
    }

    private static class JavaDiscountCourse extends JavaCourse {

        public JavaDiscountCourse(int id, String name, Double price) {
            super(id, name, price);
        }

        // // 违反里氏替换原则
        // public Double getOriginPrice() {
        // return super.getPrice();
        // }
        //
        // @Override
        // public Double getPrice() {
        // return super.getPrice() * 0.5;
        // }

        public Double getDiscountPrice() {
            return super.getPrice() * 0.5;
        }
    }
}
