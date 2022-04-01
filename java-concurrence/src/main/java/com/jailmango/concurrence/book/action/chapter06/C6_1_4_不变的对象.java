import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;

/**
 * C6_1_4
 *
 * @author jailmango
 * @CreateDate 2020/11/5
 * @see com.jailmango.concurrence.book.action.chapter06
 * @since R9.0
 */
@Slf4j
public class C6_1_4_不变的对象 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        int[] array = {
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        };

        Arrays.stream(array).map((x) -> x = x + 1).forEach(System.out::print);
        System.out.println();
        Arrays.stream(array).forEach(System.out::print);
        System.out.println();
        Arrays.stream(array).map(x -> x % 2 == 0 ? x : x + 1).forEach(System.out::print);
    }
}