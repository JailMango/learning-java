package com.jailmango.exercise.java8.ifeve.demo;

/**
 * Person
 *
 * @author he.gang33
 * @CreateDate 2019-07-01
 * @see com.jailmango.exercise.java8.ifeve.demo
 * @since R9.0
 */
public class Person {

    private String name;

    private int age;

    private int score;

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
