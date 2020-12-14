package core.basic.chapter02;

import lombok.extern.slf4j.Slf4j;

/**
 * C2_5_1_静态内部类
 *
 * @author he.gang33
 * @CreateDate 2020/11/17
 * @see core.basic.chapter02
 * @since R9.0
 */
@Slf4j
public class C2_5_1_静态内部类 {

    private static String staticClassName = "static-outer-class";

    private String className = "outer-class";

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        C2_5_1_静态内部类.StaticInnerClass staticInnerClass = new C2_5_1_静态内部类.StaticInnerClass();
        log.info("C2_5_1_静态内部类 -> Call Static...");
        StaticInnerClass.staticPrintMsg();
        log.info("C2_5_1_静态内部类 -> Call...");
        staticInnerClass.printMsg();
    }

    public static void staticOuterMethod() {
        log.info("C2_5_1_静态内部类 -> call Outer-Class Static Method...");
    }

    public void outerMethod() {
        log.info("C2_5_1_静态内部类 -> call Outer-Class Method...");
    }

    private static class StaticInnerClass {
        public static void staticPrintMsg() {
            // 可以访问外部类的静态成员变量和方法
            log.info("StaticInnerClass -> Outer-Class Static Field staticClassName = [{}]", staticClassName);
            staticOuterMethod();

            // log.info("Outer-Class Static Field className = [{}]", className);
        }

        public void printMsg() {
            log.info("StaticInnerClass -> Outer-Class Static Field staticClassName = [{}]", staticClassName);

            // 错误
            // outerMethod();
            // log.info("Outer-Class Static Field className = [{}]", className);
        }
    }
}
