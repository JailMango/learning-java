package core.basic.chapter05;

import lombok.extern.slf4j.Slf4j;

/**
 * C5_6_归并排序
 *
 * @author jailmango
 * @CreateDate 2020/11/30
 * @see core.basic.chapter05
 * @since R9.0
 */
@Slf4j
public class C5_6_归并排序 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        int[] array = {
            4, 1, 3, 9, 6, 8
        };

        int[] result = mergeSort(array);
        log.info("Result = {}", result);
    }

    private static int[] mergeSort(int[] array) {
        sort(array, 0, array.length - 1);
        return array;
    }

    private static void sort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int center = (left + right) / 2;

        sort(array, left, center);
        sort(array, center + 1, right);
        merge(array, left, center, right);
    }

    private static void merge(int[] array, int left, int center, int right) {
        int[] tmpArray = new int[array.length];

        int rightIndex = center + 1;
        int tmpIndex = left;

        int originLeft = left;

        while (left <= center && rightIndex <= right) {
            if (array[left] <= array[rightIndex]) {
                tmpArray[tmpIndex++] = array[left++];
            }
            else {
                tmpArray[tmpIndex++] = array[rightIndex++];
            }
        }

        while (rightIndex <= right) {
            tmpArray[tmpIndex++] = array[rightIndex++];
        }

        while (left <= center) {
            tmpArray[tmpIndex++] = array[left++];
        }

        while (originLeft <= right) {
            array[originLeft] = tmpArray[originLeft++];
        }
    }

}
