package com.jailmango.algorithm.geektime;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

/**
 * 20. 有效的括号
 *
 * @author jailmango
 * @CreateDate 2020/9/18
 * @see com.jailmango.algorithm.geektime
 * @since R9.0
 */
@Slf4j
public class 有效的括号 {

    private static Map<Character, Character> map = new HashMap<Character, Character>() {
        {
            put('{', '}');
            put('[', ']');
            put('(', ')');
        }
    };

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        String expr = "(){}}{";
        log.info("{}", isValid(expr));
    }

    public static boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<Character>() {
            {
                add('?');
            }
        };

        if (s.length() > 0 && !map.containsKey(s.charAt(0))) {
            return false;
        }

        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.addLast(c);
            }
            else if (map.get(stack.pop()) != c) {
                return false;
            }
        }

        return stack.size() == 1;
    }
}