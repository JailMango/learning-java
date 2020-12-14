package core.basic.chapter05;

import java.util.ArrayList;
import java.util.Collections;

import lombok.extern.slf4j.Slf4j;

/**
 * C5_7_桶排序
 *
 * @author he.gang33
 * @CreateDate 2020/12/1
 * @see core.basic.chapter05
 * @since R9.0
 */
@Slf4j
public class C5_7_桶排序 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        int[] array = {
            21, 25, 47, 36, 49, 26, 16, 8, 23, 24, 46, 5, 8, 50, 23
        };

        int[] result = bucketSort(array);
        log.info("Result = {}", result);
    }

    private static int[] bucketSort(int[] array) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            max = Math.max(max, array[i]);
            min = Math.min(min, array[i]);
        }

        int bucketNum = (max - min) / array.length + 1;
        ArrayList<ArrayList<Integer>> bucketArray = new ArrayList<>(bucketNum);

        for (int i = 0; i < bucketNum; i++) {
            bucketArray.add(new ArrayList<>());
        }

        for (int i = 0; i < array.length; i++) {
            int num = (array[i] - min) / array.length;
            bucketArray.get(num).add(array[i]);

            log.info("[{}]放入桶[{}]", array[i], num);
        }

        for (int i = 0; i < bucketNum; i++) {
            Collections.sort(bucketArray.get(i));
        }

        int index = 0;
        for (int i = 0; i < bucketArray.size(); i++) {
            for (int j = 0; j < bucketArray.get(i).size(); j++) {
                array[index++] = bucketArray.get(i).get(j);
            }
        }

        return array;
    }
}
