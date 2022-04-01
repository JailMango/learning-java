package core.basic.chapter09.单例模式;

/**
 * 懒汉模式 - 线程安全
 *
 * @author jailmango
 * @CreateDate 2020/12/8
 * @see core.basic.chapter09.单例模式
 * @since R9.0
 */
public final class LazySingleton {

    /**
     * instance
     */
    private static LazySingleton instance;

    /**
     * Constructor
     */
    private LazySingleton() {

    }

    /**
     * get instance
     * 
     * @return LazySingleton
     */
    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }

        return instance;
    }
}
