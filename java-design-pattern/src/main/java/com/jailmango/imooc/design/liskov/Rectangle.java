package com.jailmango.imooc.design.liskov;

/**
 * Rectangle
 *
 * @author jailmango
 * @CreateDate 2019-03-27
 * @see com.jailmango.imooc.design.liskov
 * @since R9.0
 */
public class Rectangle {

    private Long length;

    private Long width;

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public Long getWidth() {
        return width;
    }

    public void setWidth(Long width) {
        this.width = width;
    }
}
