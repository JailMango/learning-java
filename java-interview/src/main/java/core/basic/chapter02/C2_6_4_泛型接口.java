package core.basic.chapter02;

import lombok.extern.slf4j.Slf4j;

/**
 * C2_6_4_泛型接口
 *
 * @author jailmango
 * @CreateDate 2020/11/17
 * @see core.basic.chapter02
 * @since R9.0
 */
@Slf4j
public class C2_6_4_泛型接口 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        IGeneral a = new GeneralIntegerImpl();
        log.info("Result = {}", a.get());

        IGeneral b = new GeneralStringImpl();
        log.info("Result = {}", b.get());
    }

    private static class GeneralIntegerImpl implements IGeneral<Integer> {

        @Override
        public Integer get() {
            return 1;
        }
    }

    private static class GeneralStringImpl implements IGeneral<String> {

        @Override
        public String get() {
            return "a";
        }
    }

    private interface IGeneral<T> {

        T get();
    }
}
