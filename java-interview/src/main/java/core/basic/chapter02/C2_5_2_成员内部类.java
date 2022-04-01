package core.basic.chapter02;

import lombok.extern.slf4j.Slf4j;

/**
 * C2_5_2_成员内部类
 *
 * @author jailmango
 * @CreateDate 2020/11/17
 * @see core.basic.chapter02
 * @since R9.0
 */
@Slf4j
public class C2_5_2_成员内部类 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        OuterClass.staticPrint();
        outerClass.print();

        OuterClass.MemberInnerClass memberInnerClass = outerClass.init();
        memberInnerClass.print();

        outerClass.partClassMethod("Part Message...");
    }
}

/**
 * 外部类
 */
@Slf4j
class OuterClass {

    private static int a = 0;

    private int b = 1;

    public static void staticPrint() {
        log.info("OuterClass -> a = {}", a);

        // 错误
        // 静态方法不可以直接访问非静态成员变量
        // log.info("OuterClass -> b = {}", b);
    }

    public void print() {
        log.info("OuterClass -> a = {}", a);
        log.info("OuterClass -> b = {}", b);
    }

    public MemberInnerClass init() {
        return new MemberInnerClass();
    }

    public void partClassMethod(String msg) {
        log.info("OuterClass.partClassMethod()");

        class PartClass {
            // 错误
            // static int x = 0;

            private int x = 0;

            int y = 0;

            final int z = 0;

            public void print() {
                log.info("PartClass -> x = {}", x);
                log.info("PartClass -> y = {}", y);
                log.info("PartClass -> z = {}", z);

                log.info("PartClass -> result = {}", msg);
            }

            // 错误
            // public static void staticPrint() {
            //
            // }
        }
    }

    /**
     * 成员内部类
     */
    public class MemberInnerClass {

        // 错误
        // 成员内部类不可以定义非final的静态成员变量
        // private static int m = 0;

        // 成员内部类可以定义静态常量
        private static final int COUNT = 0;

        private int n = 1;

        // 错误
        // 成员内部类不可以定义静态方法
        // public static void staticPrint() {
        //
        // }

        public void print() {
            log.info("MemberInnerClass -> n = {}", n);
            log.info("MemberInnerClass -> a = {}", a);
            log.info("MemberInnerClass -> b = {}", b);
        }
    }
}
