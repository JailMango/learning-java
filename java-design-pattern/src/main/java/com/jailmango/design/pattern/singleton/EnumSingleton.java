package com.jailmango.design.pattern.singleton;

public enum EnumSingleton {

    /**
     * INSTANCE
     */
    INSTANCE;

    /**
     * name
     */
    private String name;

    /**
     * Constructor
     */
    EnumSingleton() {
        this.name = "Singleton";
    }

    /**
     * getInstance
     * 
     * @return String
     */
    public String getInstance() {
        return this.name;
    }
}
