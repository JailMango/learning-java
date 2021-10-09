package com.jailmango.exercise.utils.trycatch;

import lombok.extern.slf4j.Slf4j;

/**
 * TryCatchCase
 *
 * @author he.gang33
 * @CreateDate 2021/8/24
 * @see com.jailmango.exercise.utils.trycatch
 * @since R9.0
 */
@Slf4j
public class TryCatchCase {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        try {
            log.info("enter try block");

            // int a = 1 / 0;

            log.info("exit try block");

            return;
        }
        catch (Exception ex) {
            log.info("enter catch block");
        }
        finally {
            log.info("enter finally block");
        }
    }
}
