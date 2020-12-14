package core.basic.chapter02;

import lombok.extern.slf4j.Slf4j;

/**
 * C2_6_2_泛型方法
 *
 * @author he.gang33
 * @CreateDate 2020/11/17
 * @see core.basic.chapter02
 * @since R9.0
 */
@Slf4j
public class C2_6_2_泛型方法 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        generalMethod(1, "2", 3.0, new Worker() {
            @Override
            public int workTime() {
                return 0;
            }
        });
    }

    public static <T> void generalMethod(T... inputArray) {
        for (T element : inputArray) {
            if (element instanceof Integer) {
                log.info("处理Integer类型...");
            }
            else if (element instanceof String) {
                log.info("处理String类型...");
            }
            else if (element instanceof Double) {
                log.info("处理Double类型...");
            }
            else if (element instanceof Boolean) {
                log.info("处理Boolean类型...");
            }
            else if (element instanceof Worker) {
                log.info("处理Worker类型...");
            }
            else {
                log.info("其他类型...");
            }
        }
    }
}
