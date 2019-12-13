package com.jailmango.reflection.ifeve.dto;

/**
 * BaseDto
 *
 * @author he.gang33
 * @CreateDate 2019-04-18
 * @see com.jailmango.reflection.ifeve.dto
 * @since R9.0
 */
public abstract class BaseDto {

    /**
     * baseName
     */
    protected String baseName;

    /**
     * extendsFunction
     */
    public void extendsFunction() {

    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }
}
