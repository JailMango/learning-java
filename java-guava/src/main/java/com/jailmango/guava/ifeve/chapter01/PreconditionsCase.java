package com.jailmango.guava.ifeve.chapter01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;

/**
 * PreconditionsCase
 *
 * @author he.gang33
 * @CreateDate 2019-03-21
 * @see com.jailmango.java.guava.ifeve.chapter01
 * @since R9.0
 */
public class PreconditionsCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(PreconditionsCase.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        // 检查是否为true - 若不为true，则抛出java.lang.IllegalArgumentException
        Preconditions.checkArgument(Boolean.TRUE);

        // 检查是否为null - 若对象为null，则抛出java.lang.NullPointerException
        Preconditions.checkNotNull("");

        // 检查状态 - 若不为true，则抛出ava.lang.IllegalStateException
        Preconditions.checkState(Boolean.TRUE && Boolean.TRUE);

        // 检查index作为索引值对某个列表、字符串或数组是否有效 - 若index >= size，则抛出java.lang.IndexOutOfBoundsException
        Preconditions.checkElementIndex(9, 10);

        // 检查index作为位置值对某个列表、字符串或数组是否有效 - 若index > size，则抛出java.lang.IndexOutOfBoundsException
        Preconditions.checkPositionIndex(10, 10);

        // 检查[start, end]表示的位置范围对某个列表、字符串或数组是否有效
        Preconditions.checkPositionIndexes(0, 5, 5);
    }
}
