package com.jailmango.exercise.java8.ifeve.demo;

/**
 * PersonFactory
 *
 * @param <P>
 * @author jailmango
 * @CreateDate 2019-07-01
 * @see com.jailmango.exercise.java8.ifeve.demo
 * @since R9.0
 */
public interface PersonFactory<P extends Person> {

    /**
     * create
     * 
     * @param name String
     * @param age int
     * @return P
     */
    P create(String name, int age);
}
