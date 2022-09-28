package com.jailmango.algorithm;

/**
 * FeeTypeEnum
 *
 * @author gang.he2
 * @CreateDate 2022/4/28
 * @see com.jailmango.algorithm
 */
public enum FeeTypeEnum {
    TON(1, "吨"),

    SQUARE(2, "方");

    private int code;

    private String desc;

    FeeTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
