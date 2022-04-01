package com.jailmango.exercise.utils.test;

/**
 * LoopCase
 *
 * @author jailmango
 * @CreateDate 2021/3/4
 * @see com.jailmango.exercise.utils.test
 * @since R9.0
 */
public class LoopCase {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        boolean exit = false;
        int size = 331;
        int[] datasource = new int[size];

        for (int i = 0; i < size; i++) {
            datasource[i] = i;
        }

        int delta = (size - 2) / 8;


        for (int m = 0; m < size;) {
            System.out.println(m);

            if (exit) {
                break;
            }

            m += delta;

            if (m >= size) {
                m = size - 1;
                exit = true;
            }
        }

        System.out.println("exit...");
    }
}
