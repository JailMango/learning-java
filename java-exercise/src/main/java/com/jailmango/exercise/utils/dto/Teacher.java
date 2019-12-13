package com.jailmango.exercise.utils.dto;

/**
 * Teacher
 *
 * @author he.gang33
 * @CreateDate 2019-03-28
 * @see com.jailmango.exercise.utils.dto
 * @since R9.0
 */
public class Teacher implements Person {

    @Override
    public void say() {
        System.out.println("Person say() start...");
        doing();
        doingOther();
        System.out.println("Person say() end...");
    }

    protected void doing() {

        System.out.println("Teache doing()...");
    }

    private void doingOther() {
        System.out.println("doing other...");
    }
}
