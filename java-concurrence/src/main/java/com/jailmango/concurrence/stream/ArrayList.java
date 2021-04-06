package com.jailmango.concurrence.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

import com.google.common.collect.ImmutableList;

/**
 * ArrayList
 *
 * @author he.gang33
 * @CreateDate 2021/3/8
 * @see com.jailmango.concurrence.stream
 * @since R9.0
 */
@Slf4j
public class ArrayList {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Integer[] array = {
            1, 2, 3
        };
        List list = Arrays.stream(array).collect(Collectors.toList());

        int[] intArray = {
            1, 2, 3
        };
        List intList = Arrays.stream(intArray).boxed().collect(Collectors.toList());

        List<String> stringList = ImmutableList.of("string", "elements");
        List<Integer> integerList = ImmutableList.of(1, 2);

        List bb = new java.util.ArrayList();
        bb.add("1");
        bb.add("2");
        bb.add("3");
        Collections.reverse(bb);
        String[] bbbb = (String[]) bb.toArray(new String[0]);

        String[] s = new String[] {
            "dog", "lazy", "a", "over", "jumps", "fox", "brown", "quick", "A"
        };
        List<String> strList = Arrays.asList(s);
        Collections.reverse(strList);
        String[] aaaa = (String[]) list.toArray(new String[0]);

        log.info("end...");
    }
}
