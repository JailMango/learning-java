package com.jailmango.algorithm.geektime;

import java.util.Stack;

/**
 * 最小栈
 *
 * @author he.gang33
 * @CreateDate 2020/9/27
 * @see com.jailmango.algorithm.geektime
 * @since R9.0
 */
public class 最小栈 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {

    }

    private static class MinStack {

        int min = Integer.MAX_VALUE;
        Stack<Integer> stack = new Stack<Integer>();
        public void push(int x) {
            //当前值更小
            if(x <= min){
                //将之前的最小值保存
                stack.push(min);
                //更新最小值
                min=x;
            }
            stack.push(x);
        }

        public void pop() {
            //如果弹出的值是最小值，那么将下一个元素更新为最小值
            if(stack.pop() == min) {
                min=stack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }
    }
}
