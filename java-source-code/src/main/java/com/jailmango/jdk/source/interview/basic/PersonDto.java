package com.jailmango.jdk.source.interview.basic;

/**
 * PersonDto
 *
 * @author he.gang33
 * @CreateDate 2019/11/5
 * @see com.jailmango.jdk.source.interview.basic
 * @since R9.0
 */
public class PersonDto {

    /**
     * name
     */
    private String name;

    public PersonDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
