package com.jailmango.concurrence.book.core.chapter04;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// import sun.misc.Unsafe;

/**
 * Case4_1_5_2 - 4.1.5 await()方法暂停线程运行的原理
 *
 * @author jailmango
 * @CreateDate 2020/1/13
 * @see com.jailmango.concurrence.book.core.chapter04
 * @since R9.0
 */
public class Case4_1_5_2 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case4_1_5_2.class);

    public static void main(String[] args) throws InterruptedException, NoSuchFieldException, IllegalAccessException {

    }
    //
    // private static void park4() throws NoSuchFieldException, IllegalAccessException {
    //     Field field = Unsafe.class.getDeclaredField("theUnsafe");
    //     field.setAccessible(true);
    //     Unsafe unsafe = (Unsafe) field.get(null);
    //
    //     logger.info("begin...{}", System.currentTimeMillis());
    //     unsafe.park(false, 0L);
    //     logger.info("end...{}", System.currentTimeMillis());
    // }
    //
    // private static void park3() throws NoSuchFieldException, IllegalAccessException {
    //     Field field = Unsafe.class.getDeclaredField("theUnsafe");
    //     field.setAccessible(true);
    //     Unsafe unsafe = (Unsafe) field.get(null);
    //
    //     logger.info("begin...{}", System.currentTimeMillis());
    //     unsafe.park(true, 0L);
    //     logger.info("end...{}", System.currentTimeMillis());
    // }
    //
    // private static void park2() throws NoSuchFieldException, IllegalAccessException {
    //     Field field = Unsafe.class.getDeclaredField("theUnsafe");
    //     field.setAccessible(true);
    //     Unsafe unsafe = (Unsafe) field.get(null);
    //
    //     logger.info("begin...{}", System.currentTimeMillis());
    //     // 3秒
    //     // 3000毫秒
    //     // 3000000微秒
    //     // 3000000000纳秒
    //     unsafe.park(false, 3000000000L);
    //     logger.info("end...{}", System.currentTimeMillis());
    // }
    //
    // private static void park1() throws NoSuchFieldException, IllegalAccessException {
    //     Field field = Unsafe.class.getDeclaredField("theUnsafe");
    //     field.setAccessible(true);
    //     Unsafe unsafe = (Unsafe) field.get(null);
    //
    //     logger.info("begin...{}", System.currentTimeMillis());
    //     unsafe.park(true, System.currentTimeMillis() + 3000);
    //     logger.info("end...{}", System.currentTimeMillis());
    // }

}
