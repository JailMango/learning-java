package core.basic.chapter05;

import lombok.extern.slf4j.Slf4j;

/**
 * C5_1_二分查找
 *
 * @author he.gang33
 * @CreateDate 2020/11/26
 * @see core.basic.chapter05
 * @since R9.0
 */
@Slf4j
public class C5_1_二分查找 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        int[] array = {
            3, 4, 6, 20, 40, 45, 51, 62, 70, 99, 110
        };

        int index = binarySearch(array, 40);

        log.info("Result = {}", index);
    }

    private static int binarySearch(int[] array, int value) {
        int low = 0;
        int high = array.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (array[mid] == value) {
                return mid;
            }
            else if (array[mid] > value) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return -1;
    }

}
