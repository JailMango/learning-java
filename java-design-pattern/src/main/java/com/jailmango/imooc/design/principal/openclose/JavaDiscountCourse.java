package com.jailmango.imooc.design.principal.openclose;

/**
 * JavaDiscountCourse
 *
 * @author jailmango
 * @CreateDate 2019-02-27
 * @see com.jailmango.imooc.design.principal.openclose
 * @since R9.0
 */
public class JavaDiscountCourse extends JavaCourse {

    /**
     * constructor
     *
     * @param id Integer
     * @param name String
     * @param price Double
     */
    public JavaDiscountCourse(Integer id, String name, Double price) {
        super(id, name, price);
    }

    @Override
    public Double getPrice() {
        // 有精度丢失的问题，使用BigDecimal
        return super.getPrice() * 0.8;
    }
}
