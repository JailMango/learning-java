package com.jailmango.imooc.design.liskov;

/**
 * Square
 *
 * @author he.gang33
 * @CreateDate 2019-03-27
 * @see com.jailmango.imooc.design.liskov
 * @since R9.0
 */
public class Square extends Rectangle {

    private Long sideLength;

    public Long getSideLength() {
        return sideLength;
    }

    public void setSideLength(Long sideLength) {
        this.sideLength = sideLength;
    }
}
