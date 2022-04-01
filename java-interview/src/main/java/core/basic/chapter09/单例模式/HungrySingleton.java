package core.basic.chapter09.单例模式;

/**
 * HungrySingleton
 *
 * @author jailmango
 * @CreateDate 2020/12/8
 * @see core.basic.chapter09.单例模式
 * @since R9.0
 */
public final class HungrySingleton {

    private static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {

    }

    public static HungrySingleton getInstance() {
        return instance;
    }

}
