package com.jailmango.algorithm.book.chapter03.search;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * BinarySearch
 *
 * @author jailmango
 * @CreateDate 2019/11/5
 * @see com.jailmango.algorithm.book.chapter03.search
 * @since R9.0
 */
public class BinarySearch {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(BinarySearch.class);

    /**
     * main
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        String[] array = {
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"
        };

        int result = binarySearch(array, "1");
        logger.info("Index: [{}]", result);
    }

    /**
     * binarySearch
     * 
     * @param array String[]
     * @param key String
     * @return int
     */
    private static int binarySearch(String[] array, String key) {
        return binarySearch(array, 0, array.length, key);
    }

    /**
     * binarySearch
     * 
     * @param array String[]
     * @param fromIndex int
     * @param toIndex int
     * @param key String
     * @return int
     */
    private static int binarySearch(String[] array, int fromIndex, int toIndex, String key) {
        checkRange(array.length, fromIndex, toIndex);
        return binarySearch0(array, fromIndex, toIndex, key);
    }

    /**
     * 二分查找具体实现
     * 
     * @param array String[]
     * @param fromIndex int
     * @param toIndex int
     * @param key String
     * @return int
     */
    private static int binarySearch0(String[] array, int fromIndex, int toIndex, String key) {
        int count = 0;
        // low和high代表边界
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            logger.info("Search Times: [{}]", ++count);

            // 通过无符号右移一位，替代除2操作
            int mid = (low + high) >>> 1;
            String midval = array[mid];

            if (key.compareTo(midval) < 0) {
                high = mid - 1;
            }
            else if (key.compareTo(midval) > 0) {
                low = mid + 1;
            }
            else {
                return mid;
            }
        }

        return -(low + 1);
    }

    /**
     * 范围检查
     * 
     * @param length int
     * @param fromIndex int
     * @param toIndex int
     */
    private static void checkRange(int length, int fromIndex, int toIndex) {
        if (fromIndex > toIndex) {
            throw new IllegalArgumentException("fromIndex(" + fromIndex + ") > toIndex(" + toIndex + ")");
        }

        if (fromIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(fromIndex);
        }
        if (toIndex > length) {
            throw new ArrayIndexOutOfBoundsException(toIndex);
        }
    }

}
