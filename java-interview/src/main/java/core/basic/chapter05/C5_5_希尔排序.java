package core.basic.chapter05;

import lombok.extern.slf4j.Slf4j;

/**
 * C5_5_希尔排序
 *
 * @author jailmango
 * @CreateDate 2020/11/29
 * @see core.basic.chapter05
 * @since R9.0
 */
@Slf4j
public class C5_5_希尔排序 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Integer[] array = {
            21, 25, 47, 36, 49, 26, 16, 8, 23, 24, 46, 5, 8, 50, 23
        };

        Integer[] result = shellSort(array);
        log.info("Result = {}", result);
    }

    /**
     * 希尔排序算法实现
     * 
     * @param array Integer[]
     * @return Integer[]
     */
    private static Integer[] shellSort(Integer[] array) {
        int total = array.length;
        int delta = 1;

        while (delta < total / 3) {
            delta = 3 * delta + 1;
        }

        while (delta >= 1) {
            for (int i = delta; i < total; i++) {
                int index = i;
                for (; index >= delta && 排序模板.less(array[index], array[index - delta]); index = index - delta) {
                    排序模板.exchange(array, index, index - delta);
                }
            }
            delta /= 3;
        }

        return array;
    }
}
