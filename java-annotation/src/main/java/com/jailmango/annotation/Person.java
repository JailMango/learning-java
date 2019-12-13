package com.jailmango.annotation;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Repeatable(Persons.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Person {

    /**
     * 岗位
     * 
     * @return String
     */
    String role() default "EMPLOYEE";
}