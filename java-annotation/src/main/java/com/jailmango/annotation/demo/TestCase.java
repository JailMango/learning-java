package com.jailmango.annotation.demo;

/**
 * TestCase
 *
 * @author jailmango
 * @CreateDate 2018/10/22
 * @see com.jailmango.java.annotation.demo
 * @since R9.0<br>
 */
public class TestCase {

    /**
     * 加法
     */
    @Check
    public void addition() {
        System.out.println("1 + 1 = " + 1 + 1);
    }

    /**
     * 减法
     */
    @Check
    public void subtraction() {
        System.out.println("1 - 1 = " + (1 - 1));
    }

    /**
     * 乘法
     */
    @Check
    public void multiplication() {
        System.out.println("3 x 5 =" + 3 * 5);
    }

    /**
     * 除法
     */
    @Check
    public void division() {
        System.out.println("6 / 0 =" + 6 / 0);
    }

    /**
     * 简介
     */
    public void helloWorld() {
        System.out.println("我写的程序没有 bug!");
    }
}
