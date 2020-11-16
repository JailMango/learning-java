package com.jailmango.concurrence.book.action.chapter05;

import lombok.extern.slf4j.Slf4j;

/**
 * C5_8_1_冒泡排序
 *
 * @author he.gang33
 * @CreateDate 2020/10/27
 * @see com.jailmango.concurrence.book.action.chapter05
 * @since R9.0
 */
@Slf4j
public class C5_8_1_串行冒泡排序 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        int[] array = {
            5, 52, 6, 3, 4, 16, 14, 17, 11, 9
        };

        int[] result = bubbleSort(array);

        log.info("结束...");
    }

    /**
     * 冒泡排序
     * 
     * @param array int[]
     */
    public static int[] bubbleSort(int[] array) {
        for (int outer = array.length - 1; outer > 0; outer--) {
            for (int inner = 0; inner < outer; inner++) {
                if (array[inner] > array[inner + 1]) {
                    int temp = array[inner];
                    array[inner] = array[inner + 1];
                    array[inner + 1] = temp;
                }
            }
        }

        return array;
    }
}
