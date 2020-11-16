package com.jailmango.algorithm.geektime;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * 交换值
 *
 * @author he.gang33
 * @CreateDate 2020/9/17
 * @see com.jailmango.algorithm.geektime
 * @since R9.0
 */
@Slf4j
public class 交换值 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        MyObject a = MyObject.builder().value("a").build();
        MyObject b = MyObject.builder().value("b").build();
        MyObject c = null;

        c = a;
        a = b;
        b = c;

        log.info("end...");
    }

    @Data
    @Builder
    @ToString
    private static class MyObject {

        private String value;
    }
}
