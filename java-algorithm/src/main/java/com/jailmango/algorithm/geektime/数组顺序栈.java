package com.jailmango.algorithm.geektime;

import lombok.extern.slf4j.Slf4j;

/**
 * 数组顺序栈
 *
 * @author jailmango
 * @CreateDate 2020/9/18
 * @see com.jailmango.algorithm.geektime
 * @since R9.0
 */
@Slf4j
public class 数组顺序栈 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);

        log.info("push -> {}", stack.push("1"));
        log.info("push -> {}", stack.push("2"));
        log.info("push -> {}", stack.push("3"));
        log.info("push -> {}", stack.push("4"));
        log.info("push -> {}", stack.push("5"));
        log.info("push -> {}", stack.push("6"));

        log.info("pop -> {}", stack.pop());
        log.info("pop -> {}", stack.pop());
        log.info("pop -> {}", stack.pop());
        log.info("pop -> {}", stack.pop());
        log.info("pop -> {}", stack.pop());
        log.info("pop -> {}", stack.pop());
    }

    private static class ArrayStack {

        private String[] data;

        private int count;

        private int length;

        public ArrayStack(int length) {
            this.length = length;
            this.count = 0;
            this.data = new String[this.length];
        }

        public boolean push(String element) {
            if (this.count >= this.length) {
                return false;
            }

            this.data[this.count] = element;
            this.count++;

            return true;
        }

        public String pop() {
            if (this.count == 0) {
                return null;
            }

            String result = this.data[this.count-1];
            this.count--;

            return result;
        }
    }
}
