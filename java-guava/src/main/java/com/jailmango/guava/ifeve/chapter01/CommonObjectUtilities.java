package com.jailmango.guava.ifeve.chapter01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

/**
 * CommonObjectUtilities
 *
 * @author jailmango
 * @CreateDate 2019-03-21
 * @see com.jailmango.java.guava.ifeve.chapter01
 * @since R9.0
 */
public class CommonObjectUtilities {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(CommonObjectUtilities.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        String strObj1 = "hello";
        String strObj2 = "hello";
        logger.info(String.valueOf(Objects.equal(strObj1, strObj2)));
        logger.info(String.valueOf(Objects.equal(null, strObj1)));

        HashObj hashObj1 = new HashObj("name1", 10, "male");
        HashObj hashObj2 = new HashObj("name2", 20, "female");
        // guava
        logger.info("Object1 hashcode: [" + Objects.hashCode(hashObj1) + "]");
        logger.info("Object2 hashcode: [" + Objects.hashCode(hashObj2) + "]");
        logger.info("Compare: [" + hashObj1.compareTo(hashObj2) + "]");

        GuavaObj guavaObj1 = new GuavaObj("z", 10, "male");
        GuavaObj guavaObj2 = new GuavaObj("a", 20, "female");
        logger.info("Compare: [" + guavaObj1.compareTo(guavaObj2) + "]");

        // jdk
        logger.info("Object1 hashcode: [" + java.util.Objects.hash(hashObj1) + "]");
        logger.info("Object2 hashcode: [" + java.util.Objects.hash(hashObj2) + "]");
        logger.info("Object1 toString: [" + java.util.Objects.toString(hashObj1) + "]");
        logger.info("Object2 toString: [" + java.util.Objects.toString(hashObj2) + "]");
    }

    private static class HashObj implements Comparable<HashObj> {

        /**
         * name
         */
        private String name;

        /**
         * age
         */
        private int age;

        /**
         * sex
         */
        private String sex;

        /**
         * Constructor
         * 
         * @param name String
         * @param age int
         * @param sex String
         */
        public HashObj(String name, int age, String sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        @Override
        public int compareTo(HashObj o) {
            int result = this.name.compareTo(o.name);

            if (0 != result) {
                return result;
            }

            result = Integer.compare(this.age, o.age);

            if (0 != result) {
                return result;
            }

            return this.sex.compareTo(o.sex);
        }
    }

    private static class GuavaObj {

        /**
         * name
         */
        private String name;

        /**
         * age
         */
        private int age;

        /**
         * sex
         */
        private String sex;

        /**
         * Constructor
         * 
         * @param name String
         * @param age int
         * @param sex String
         */
        public GuavaObj(String name, int age, String sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        /**
         * 比较
         * 
         * @param that GuavaObj
         * @return int
         */
        public int compareTo(GuavaObj that) {
            return ComparisonChain.start().compare(this.name, that.name).compare(this.age, that.age)
                .compare(this.sex, that.sex).result();
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }
    }
}
