package com.jailmango.exercise.utils.array;

/**
 * Copy
 *
 * @author he.gang33
 * @CreateDate 2021/2/23
 * @see com.jailmango.exercise.utils.array
 * @since R9.0
 */
public class Copy {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        String[] array = {"0", "1", "2", "3", "4"};

        String[] dest = new String[10];
        System.arraycopy(array, 0, dest, 0, 3);

        System.out.println("end...");
    }
}
