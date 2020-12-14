package core.basic.chapter02;

import lombok.extern.slf4j.Slf4j;

/**
 * C2_6_3_反省类
 *
 * @author he.gang33
 * @CreateDate 2020/11/17
 * @see core.basic.chapter02
 * @since R9.0
 */
@Slf4j
public class C2_6_3_泛型类 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        GeneralClass<Integer> integerClass = new GeneralClass<>();
        integerClass.set(1);
        log.info("Result = {}", integerClass.get());

        GeneralClass<String> stringClass = new GeneralClass<>();
        stringClass.set("a");
        log.info("Result = {}", stringClass.get());
    }

    private static class GeneralClass<T> {

        private T t;

        public void set(T t) {
            this.t = t;
        }

        public T get() {
            return this.t;
        }
    }
}
