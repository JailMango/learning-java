package com.jailmango.exercise.utils.obj;

import java.io.Serializable;

/**
 * SerializableDto
 *
 * @author jailmango
 * @CreateDate 2019-03-07
 * @see com.jailmango.exercise.utils.obj
 * @since R9.0
 */
public class SerializableDto implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 6357183720463571227L;

    /**
     * name
     */
    private String name;

    /**
     * age
     */
    private int age;

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
}
