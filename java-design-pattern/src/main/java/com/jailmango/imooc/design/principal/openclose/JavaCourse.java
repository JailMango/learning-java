package com.jailmango.imooc.design.principal.openclose;

/**
 * JavaCourse
 *
 * @author jailmango
 * @CreateDate 2019-02-27
 * @see com.jailmango.imooc.design.principal.openclose.impl
 * @since R9.0
 */
public class JavaCourse implements ICourse {

    /**
     * Integer
     */
    private Integer id;

    /**
     * name
     */
    private String name;

    /**
     * Double
     */
    private Double price;

    /**
     * constructor
     * 
     * @param id Integer
     * @param name String
     * @param price Double
     */
    public JavaCourse(Integer id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }
}
