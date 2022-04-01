package com.jailmango.concurrence.book.action.chapter05;

import lombok.extern.slf4j.Slf4j;

/**
 * C5_8_1_串行奇偶交换
 *
 * @author jailmango
 * @CreateDate 2020/10/27
 * @see com.jailmango.concurrence.book.action.chapter05
 * @since R9.0
 */
@Slf4j
public class C5_8_1_串行奇偶交换 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        int[] array = {
            5, 6, 3, 2, 1
        };

        int[] result = oddEventSort(array);
        log.info("end...");
    }

    public static int[] oddEventSort(int[] array) {
        boolean exchangeFlag = true;
        int start = 0;

        while (exchangeFlag || start == 1) {
            exchangeFlag = false;

            for (int i = start; i < array.length - 1; i += 2) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    exchangeFlag = true;
                }
            }

            start = start == 0 ? 1 : 0;
        }

        return array;
    }
}
