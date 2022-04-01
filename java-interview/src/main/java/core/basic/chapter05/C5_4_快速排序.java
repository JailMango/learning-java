package core.basic.chapter05;

import lombok.extern.slf4j.Slf4j;

/**
 * C5_4_快速排序
 *
 * @author jailmango
 * @CreateDate 2020/11/29
 * @see core.basic.chapter05
 * @since R9.0
 */
@Slf4j
public class C5_4_快速排序 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        int[] array = {
            6, 9, 5, 7, 8
        };

        int[] result = quickSort(array, 0, array.length - 1);
        log.info("Result = {}", result);
    }

    private static int[] quickSort(int[] array, int low, int high) {
        int start = low;
        int end = high;
        int key = array[low];

        while (end > start) {
            // 从后往前找找
            while (end > start && array[end] >= key) {
                end--;
            }

            // 如果比基准值小，则交换和基准值的位置
            if (array[end] < key) {
                int tmp = array[start];
                array[start] = array[end];
                array[end] = tmp;
            }

            // 从前往后找
            while (end > start && array[start] <= key) {
                start++;
            }

            if (array[start] >= key) {
                int tmp = array[start];
                array[start] = array[end];
                array[end] = tmp;
            }
        }

        if (start > low) {
            quickSort(array, low, start - 1);
        }

        if (end < high) {
            quickSort(array, end + 1, high);
        }

        return array;
    }
}
