package com.jailmango.jdk.source.interview.basic;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableList;

/**
 * ArraysCase
 *
 * @author jailmango
 * @CreateDate 2019/11/5
 * @see com.jailmango.jdk.source.interview.basic
 * @since R9.0
 */
public class ArraysCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ArraysCase.class);

    public static void main(String[] args) {

    }

    /**
     * Arrays.sort()进行排序
     */
    private static void sort() {
        // 使用guava创建list
        List<SortDto> list = ImmutableList.of(new SortDto("300"), new SortDto("50"), new SortDto("220"),
            new SortDto("200"));

        // list转换为数组
        SortDto[] array = new SortDto[list.size()];
        list.toArray(array);

        logger.info("before sort...");

        // Arrays.sort(array, new Comparator<SortDto>() {
        // @Override
        // public int compare(SortDto o1, SortDto o2) {
        // return o1.getName().compareTo(o2.getName());
        // }
        // });

        // 可简化为如下lambda表达式
        // Arrays.sort(array, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        // 可进一步简化为如下写法
        Arrays.sort(array, Comparator.comparing(SortDto::getName));
        logger.info("after sort...");
    }

    private static void binarySearch() {
        // 使用guava创建list
        List<SortDto> list = ImmutableList.of(new SortDto("300"), new SortDto("50"), new SortDto("220"),
            new SortDto("200"), new SortDto("100"));

        // list转换为数组
        SortDto[] array = new SortDto[list.size()];
        list.toArray(array);

        int index = Arrays.binarySearch(array, new SortDto("200"), Comparator.comparing(SortDto::getName));
        // 由于数组未排序，因此导致找不到
        logger.info("Without sorting... Index: []", index);

        Arrays.sort(array, Comparator.comparing(SortDto::getName));

        index = Arrays.binarySearch(array, new SortDto("200"), Comparator.comparing(SortDto::getName));
        // 由于数组未排序，因此导致找不到
        logger.info("With sorting... Index: []", index);
    }

    private static void copy() {
        List<String> list = ImmutableList.of("0", "1", "2", "3", "4");

        String[] array = new String[list.size()];
        list.toArray(array);

        String[] newArray = Arrays.copyOf(array, 3);

        logger.info("copy end...");
    }

    /**
     * 二分查找 - JDK实现
     * 
     * @param a T[]
     * @param fromIndex int
     * @param toIndex int
     * @param key T
     * @param c Comparator<? super T>
     * @param <T> T
     * @return int
     */
    private static <T> int binarySearch0(T[] a, int fromIndex, int toIndex, T key, Comparator<? super T> c) {
        if (c == null) {
            return binarySearch0(a, fromIndex, toIndex, key);
        }
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            // 使用无符号右移一位操作，替代除2操作
            int mid = (low + high) >>> 1;
            T midVal = a[mid];
            int cmp = c.compare(midVal, key);
            if (cmp < 0) {
                low = mid + 1;
            }
            else if (cmp > 0) {
                high = mid - 1;
            }
            else {
                // key found
                return mid;
            }
        }
        // key not found.
        return -(low + 1);
    }

    /**
     * 二分查找 - JDK实现
     * 
     * @param a Object[]
     * @param fromIndex int
     * @param toIndex int
     * @param key Object
     * @return int
     */
    private static int binarySearch0(Object[] a, int fromIndex, int toIndex, Object key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            Comparable midVal = (Comparable) a[mid];
            int cmp = midVal.compareTo(key);

            if (cmp < 0) {
                low = mid + 1;
            }
            else if (cmp > 0) {
                high = mid - 1;
            }
            else {
                // key found
                return mid;
            }
        }
        // key not found.
        return -(low + 1);
    }

    /**
     * 数组拷贝 - JDK实现
     * 
     * @param original U[]
     * @param from int
     * @param to int
     * @param newType Class<? extends T[]>
     * @param <T> T
     * @param <U> U
     * @return T[]
     */
    public static <T, U> T[] copyOfRange(U[] original, int from, int to, Class<? extends T[]> newType) {
        //int newLength = to - from;
        //if (newLength < 0) {
        //    throw new IllegalArgumentException(from + " > " + to);
        //}

        //T[] copy = (newType == Object[].class) ? (T[]) new Object[newLength]
        //    : (T[]) Array.newInstance(newType.getComponentType(), newLength);
        //System.arraycopy(original, from, copy, 0, Math.min(original.length - from, newLength));
        //return copy;

        return null;
    }
}
