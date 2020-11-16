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
public class C5_8_2_希尔排序 {

    // static int[] array = {
    // 5, 52, 6, 3, 4, 10, 8, 100, 35, 78, 64, 31, 77, 90, 45, 53, 89, 78, 1, 7, 152, 16, 13, 14, 100, 80, 70, 53, 2,
    // 46, 23, 79, 190, 25, 27, 21, 48, 0
    // };

//    static int[] array = {
//        5, 52, 6, 3, 4, 10, 8, 100, 35, 78, 64, 31, 77, 90
//    };

    static int[] array = {
            5, 52, 6, 3, 4, 10, 8, 100
    };


    static int count = 0;

    /**
     * 希尔排序
     * 
     * @param array
     */
    public static void shellSort(int[] array) {
        int step = 1;

        // while (h <= array.length / 3) {
        // h = h * 3 + 1;
        // }

        step = array.length / 2;

        log.info("初始Step = {}", step);

        while (step > 0) {
            // 从右侧(即第二个数组)开始遍历
            for (int right = step; right < array.length; right++) { if (array[right] < array[right - step]) {
                    int tmp = array[right];
                    int left = right - step;
                    while (left >= 0 && array[left] > tmp) {
                        array[left + step] = array[left];
                        left -= step;
                        count++;
                    }

                    array[left + step] = tmp;
                }
            }

            // h = (h - 1) / 3;
            step = step / 2;
            log.info("Step = {}", step);
        }

        log.info("Count = {}", count);
    }

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        shellSort(array);

        log.info("end...");
    }
}
