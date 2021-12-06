package com.jailmango.exercise.utils.optional;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Optional;

/**
 * OptionalCase
 *
 * @author he.gang33
 * @CreateDate 2021/11/16
 * @see com.jailmango.exercise.utils.optional
 */
public class OptionalCase {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        List<Long> l1 = null;
        List<Long> l2 = Lists.newArrayList(1L, 2L);

        List<Long> l3 = Optional.ofNullable(l1).orElse(Lists.newArrayList());
        List<Long> l4 = Optional.ofNullable(l2).orElse(Lists.newArrayList());


    }
}
