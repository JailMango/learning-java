package com.jailmango.rmi;

import java.io.Serializable;

/**
 * UserDto
 *
 * @author he.gang33
 * @CreateDate 2019-06-20
 * @see com.jailmango.rmi
 * @since R9.0
 */
public class UserDto implements Serializable {

    private static final long serialVersionUID = 7214434918887292314L;

    private Long id;

    private String name;

    private int age;

    public UserDto() {

    }

    public UserDto(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
