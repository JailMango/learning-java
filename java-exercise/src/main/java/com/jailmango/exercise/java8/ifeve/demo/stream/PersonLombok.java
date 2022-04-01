package com.jailmango.exercise.java8.ifeve.demo.stream;

import com.jailmango.exercise.java8.ifeve.demo.Person;
import lombok.extern.slf4j.Slf4j;

/**
 * PersonLombok
 *
 * @author jailmango
 * @see com.jailmango.exercise.java8.ifeve.demo.stream
 */
@Slf4j
public class PersonLombok {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Person person = Person.builder().age(100).name("111").score(100).build();

        log.info("end...");
    }
}
