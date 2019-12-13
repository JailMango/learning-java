package com.jailmango.rmi.entity;

import java.io.Serializable;

/**
 * UserDto
 *
 * @author he.gang33
 * @CreateDate 2019-07-03
 * @see com.jailmango.rmi.entity
 * @since R9.0
 */
public class UserDto implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -1249089879367579440L;

    /**
     * name
     */
    private String name;

    /**
     * Constructor
     * 
     * @param name String
     */
    public UserDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
