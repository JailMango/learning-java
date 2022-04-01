package core.basic.chapter05;

import lombok.extern.slf4j.Slf4j;

/**
 * 排序模板
 *
 * @author jailmango
 * @CreateDate 2020/11/30
 * @see core.basic.chapter05
 * @since R9.0
 */
@Slf4j
public final class 排序模板 {

    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void exchange(Comparable[] array, int m, int n) {
        Comparable temp = array[m];
        array[m] = array[n];
        array[n] = temp;

        log.info("交换[{}]和[{}]", m, n);
    }
}
