package com.jailmango.algorithm.geektime;

import java.util.Stack;

import lombok.extern.slf4j.Slf4j;

/**
 * 844. 比较含退格的字符串
 *
 * @author jailmango
 * @CreateDate 2020/9/28
 * @see com.jailmango.algorithm.geektime
 * @since R9.0
 */
@Slf4j
public class 比较含退格的字符串 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        log.info("backspaceCompare(\"ab#c\", \"ad#c\") -> {}", backspaceCompare("ab#c", "ad#c"));
        log.info("backspaceCompare(\"ab#c\", \"ad#c\") -> {}", backspaceCompare("ab##", "c#d#"));
        log.info("backspaceCompare(\"ab#c\", \"ad#c\") -> {}", backspaceCompare("a##c", "#a#c"));
        log.info("backspaceCompare(\"ab#c\", \"ad#c\") -> {}", backspaceCompare("a#c", "b"));

        log.info("end...");
    }

    public static boolean backspaceCompare(String S, String T) {
        return false;
    }

    /**
     * 解法1 时间复杂度 O(M+N) 空间复杂度 O(M+N)
     */
    public static boolean backspaceCompare1(String S, String T) {
        boolean isSame = true;

        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();

        char[] array = S.toCharArray();
        transfer(stackS, array);

        array = T.toCharArray();
        transfer(stackT, array);

        while (!stackS.empty() || !stackT.empty()) {
            if (stackS.empty() ^ stackT.empty()) {
                isSame = false;
                break;
            }
            else {
                if (!(stackS.pop().equals(stackT.pop()))) {
                    isSame = false;
                    break;
                }
            }
        }

        return isSame;
    }

    private static void transfer(Stack<Character> stack, char[] array) {
        for (char c : array) {
            if ('#' == c) {
                if (!stack.empty()) {
                    stack.pop();
                }
            }
            else {
                stack.push(c);
            }
        }
    }

}
