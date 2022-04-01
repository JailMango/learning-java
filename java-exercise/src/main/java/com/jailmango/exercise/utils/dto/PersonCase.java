package com.jailmango.exercise.utils.dto;

/**
 * PersonCase
 *
 * @author jailmango
 * @CreateDate 2019-03-28
 * @see com.jailmango.exercise.utils.dto
 * @since R9.0
 */
public class PersonCase {

    public static void main(String[] args) {
        Person teacher = new Teacher();
        teacher.say();

        System.out.println("==========================");

        Person student = new Student();
        student.say();

    }
}
