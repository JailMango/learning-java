package com.jailmango.exercise.java8.ifeve.demo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Person
 *
 * @author he.gang33
 * @CreateDate 2019-07-01
 * @see com.jailmango.exercise.java8.ifeve.demo
 * @since R9.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String name;

    private int age;

    private int score;

    private Date birth;
}
