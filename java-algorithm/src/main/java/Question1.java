import java.util.Objects;

/**
 * Question1 - 冒泡排序
 *
 * @author gang.he2
 * @CreateDate 2022/4/12
 */
public class Question1 {

    private static final int ASC = 0;

    private static final int DESC = 1;

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        int[] array = {10, 9, 6, 7, 8, 12, 1, 4, 2, 4};

        bubbleSort(array, ASC);

        int a = 1;
    }

    /**
     * 冒泡排序
     *
     * @param array 待排序数组
     * @param order 升序/降序
     * @return int[]
     */
    public static int[] bubbleSort(int[] array, int order) {
        if (Objects.isNull(array)) {
            return new int[0];
        }

        for (int left = 0; left < array.length; left++) {
            for (int right = left + 1; right < array.length; right++) {
                if (isNeedSwap(array, left, right, order)) {
                    swap(array, left, right);
                }
            }
        }

        return array;
    }

    private static boolean isNeedSwap(int[] array, int left, int right, int order) {
        // 降序，左 < 右，需要交换；升序，左 > 右，需要交换
        return DESC == order ? array[left] < array[right] : array[left] > array[right];
    }

    private static void swap(int[] array, int left, int right) {
        int tmp = array[right];
        array[right] = array[left];
        array[left] = tmp;
    }
}
