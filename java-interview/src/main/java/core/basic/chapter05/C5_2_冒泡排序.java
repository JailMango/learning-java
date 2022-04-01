package core.basic.chapter05;

import lombok.extern.slf4j.Slf4j;

/**
 * C5_2_冒泡排序
 *
 * @author jailmango
 * @CreateDate 2020/11/26
 * @see core.basic.chapter05
 * @since R9.0
 */
@Slf4j
public class C5_2_冒泡排序 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        int[] array = {
            4, 5, 6, 3, 2, 1
        };

        int[] result = bubboSort(array);

        log.info("{}", result);
    }

    private static int[] bubboSort(int[] array) {
        int tmp;

        for (int i = 0; i < array.length - 1; i++) {
            for (int m = 0; m < array.length - 1 - i; m++) {
                if (array[m] > array[m + 1]) {
                    tmp = array[m + 1];
                    array[m + 1] = array[m];
                    array[m] = tmp;
                }
            }
        }

        return array;
    }
}
