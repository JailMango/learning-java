package com.jailmango.jdk.source.interview.basic;

/**
 * ParentInterface
 *
 * @author jailmango
 * @CreateDate 2019/10/29
 * @see com.jailmango.jdk.source.interview.basic
 * @since R9.0
 */
public interface ParentInterface {

    default int add(int a, int b) {
        return a + b;
    }
}
