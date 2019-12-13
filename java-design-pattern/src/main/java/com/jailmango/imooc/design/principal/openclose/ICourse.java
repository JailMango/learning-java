package com.jailmango.imooc.design.principal.openclose;

/**
 * ICourse
 *
 * @author he.gang33
 * @CreateDate 2019-02-27
 * @see com.jailmango.imooc.design.principal.openclose
 * @since R9.0
 */
public interface ICourse {

    /**
     * getId
     * 
     * @return Integer
     */
    Integer getId();

    /**
     * getName
     * 
     * @return String
     */
    String getName();

    /**
     * getPrice
     * 
     * @return Double
     */
    Double getPrice();
}
