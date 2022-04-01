package com.jailmango.exercise.utils.dto;

/**
 * Student
 *
 * @author jailmango
 * @CreateDate 2019-03-28
 * @see com.jailmango.exercise.utils.dto
 * @since R9.0
 */
public class Student extends Teacher {

    @Override
    protected void doing() {
        System.out.println("Student doing()...");
    }
}
