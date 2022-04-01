package core.basic.chapter05;

import lombok.extern.slf4j.Slf4j;

/**
 * C5_8_基数排序
 *
 * @author jailmango
 * @CreateDate 2020/12/1
 * @see core.basic.chapter05
 * @since R9.0
 */
@Slf4j
public class C5_8_基数排序 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        int[] array = {
            1, 56, 7, 5, 304, 12, 102, 45, 183, 3, 345, 123
        };

        int[] result = radixSort(array, 3);
        log.info("Result = {}", result);
    }

    private static int[] radixSort(int[] array, int maxDigit) {
        double max = Math.pow(10, maxDigit);
        int n = 1;
        int k = 0;
        int length = array.length;
        int[][] bucket = new int[10][length];
        int[] order = new int[length];

        while (n < max) {
            for (int num : array) {
                int digit = (num / n) % 10;
                bucket[digit][order[digit]] = num;
                order[digit]++;
            }

            for (int i = 0; i < length; i++) {
                if (order[i] != 0) {
                    for (int j = 0; j < order[i]; j++) {
                        array[k++] = bucket[i][j];
                    }
                }

                order[i] = 0;
            }

            n *= 10;
            k = 0;
        }

        return array;
    }
}
