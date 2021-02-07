package com.jailmango.exercise.utils.jvm;

/**
 * JVM
 *
 * @author he.gang33
 * @CreateDate 2021/1/11
 * @see com.jailmango.exercise.utils.jvm
 * @since R9.0
 */
public class JVM {

    private static JVM test2 = new JVM();

    private static int value1;
    private static int value2 = 3;



    private JVM() {
//        value1 ++;
//        value2 ++;
    }

    public static void main(String[] args) {
        // 1
        System.out.println(test2.value1);
        // 3
        System.out.println(test2.value2);
    }
}