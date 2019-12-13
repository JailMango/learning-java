package com.jailmango.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Inherited
public @interface Message {

    /**
     * 消息标识
     * 
     * @return int
     */
    int id() default 1;

    /**
     * 消息内容
     * 
     * @return String
     */
    String msg() default "default msg";
}
