package com.jailmango.spring.application.utils;

import org.springframework.stereotype.Component;

/**
 * NumberUtils
 *
 * @author he.gang33
 * @CreateDate 2021/12/3
 * @see com.jailmango.spring.application.utils
 */
@Component
public class NumberUtils {

    public int add(int a, int b) {
        return a + b;
    }

    public int multi(int a, int b) {
        return a * b;
    }
}
