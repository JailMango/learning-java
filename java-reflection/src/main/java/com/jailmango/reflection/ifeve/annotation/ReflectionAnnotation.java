package com.jailmango.reflection.ifeve.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ReflectionAnnotation
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({
    ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD
})
@Inherited
public @interface ReflectionAnnotation {

    /**
     * name
     * 
     * @return String
     */
    String name();
}
