package com.jailmango.concurrence.book.action.chapter06;

/**
 * C6_2_1_函数式接口定义 <br/>
 * 函数式接口只允许定义一个抽象方法。<br/>
 * 强调只能有一个抽象方法，而不是方法。
 *
 * @author jailmango
 * @CreateDate 2020/11/5
 * @see com.jailmango.concurrence.book.action.chapter06
 * @since R9.0
 */
@FunctionalInterface
public interface C6_2_1_函数式接口定义 {

    void handle();

    /**
     * 函数式接口，可以有默认方法
     */
    default void service() {
        System.out.println("do service...");
    }

    /**
     * 函数式接口，可以有
     * @param object
     * @return
     */
    @Override
    boolean equals(Object object);

    // void anotherHandle();
}
