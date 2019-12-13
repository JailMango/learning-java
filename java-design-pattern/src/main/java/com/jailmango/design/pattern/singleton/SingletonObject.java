package com.jailmango.design.pattern.singleton;

/**
 * SingletonObject - 单例
 *
 * @author he.gang33
 * @CreateDate 2019-01-22
 * @see com.jailmango.java.design.pattern.singleton
 * @since R9.0
 */
public final class SingletonObject {

    /**
     * instance
     */
    private static SingletonObject instance;

    /**
     * constructor
     */
    private SingletonObject() {
    }

    /**
     * getInstance
     * 
     * @return SingletonObject
     */
    public static SingletonObject getInstance() {
        if (null == instance) {
            instance = new SingletonObject();
        }
        return instance;
    }
}
