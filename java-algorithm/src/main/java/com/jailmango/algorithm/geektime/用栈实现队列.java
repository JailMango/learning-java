package com.jailmango.algorithm.geektime;

import java.util.Stack;

import lombok.extern.slf4j.Slf4j;

/**
 * 232. 用栈实现队列
 *
 * @author jailmango
 * @CreateDate 2020/9/27
 * @see com.jailmango.algorithm.geektime
 * @since R9.0
 */
@Slf4j
public class 用栈实现队列 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();

        for (int i = 0; i < 10; i++) {
            myQueue.push(i);
        }

        for (int i = 0; i < 3; i++) {
            log.info("peek -> {}", myQueue.peek());
        }

        for (int i = 0; i < 3; i++) {
            log.info("pop -> {}", myQueue.pop());
        }

        myQueue.push(111);
        myQueue.push(222);
        myQueue.push(333);
        myQueue.push(444);

        for (int i = 0; i < 11; i++) {
            log.info("pop -> {}", myQueue.pop());
        }

        log.info("end...");
    }

    private static class MyQueue {

        private Stack<Integer> pushStack = new Stack<>();

        private Stack<Integer> popStack = new Stack<>();

        /** Initialize your data structure here. */
        public MyQueue() {

        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            pushStack.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            transferData();

            return popStack.pop();
        }

        /** Get the front element. */
        public int peek() {
            transferData();

            return popStack.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return pushStack.empty() && popStack.empty();
        }

        private void transferData() {
            if (popStack.empty()) {
                while (!pushStack.empty()) {
                    popStack.push(pushStack.pop());
                }
            }
        }
    }

}
