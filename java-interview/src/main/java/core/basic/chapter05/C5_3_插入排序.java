package core.basic.chapter05;

import lombok.extern.slf4j.Slf4j;

/**
 * C5_3_插入排序
 *
 * @author jailmango
 * @CreateDate 2020/11/27
 * @see core.basic.chapter05
 * @since R9.0
 */
@Slf4j
public class C5_3_插入排序 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        int[] array = {
            6, 2, 5, 8, 7
        };

        int[] result = insertSort(array);

        log.info("{}", result);
    }

    private static int[] insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int insertVal = array[i];

            int index = i - 1;
            while (index >= 0 && insertVal < array[index]) {
                array[index + 1] = array[index];
                index--;
            }
            array[index + 1] = insertVal;
        }

        return array;
    }
}
