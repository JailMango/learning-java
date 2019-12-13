package com.jailmango.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Persons
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Persons {

    /**
     * value
     * 
     * @return Person[]
     */
    Person[] value();
}
