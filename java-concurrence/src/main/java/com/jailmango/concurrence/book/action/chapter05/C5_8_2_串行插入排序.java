package com.jailmango.concurrence.book.action.chapter05;

import lombok.extern.slf4j.Slf4j;

/**
 * C5_8_2_插入排序
 *
 * @author he.gang33
 * @CreateDate 2020/10/28
 * @see com.jailmango.concurrence.book.action.chapter05
 * @since R9.0
 */
@Slf4j
public class C5_8_2_串行插入排序 {

    static int[] array = {
        5, 52, 6, 3, 4, 10, 8, 100, 35, 78, 64, 31, 77, 90, 45, 53, 89, 78, 1
    };

    /**
     * 插入排序
     * 
     * @param array
     */
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = key;
        }
    }

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        insertSort(array);

        log.info("end...");
    }
}
