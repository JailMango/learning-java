package core.basic.chapter09.单例模式;

/**
 * 单例模式 - 双重锁检查
 *
 * @author he.gang33
 * @CreateDate 2020/12/9
 * @see core.basic.chapter09.单例模式
 * @since R9.0
 */
public class DoubleCheckSingleton {

    private volatile static DoubleCheckSingleton instance;

    private DoubleCheckSingleton() {

    }

    public static DoubleCheckSingleton getInstance() {
        if (instance == null) {
            synchronized (Object.class) {
                if (instance == null) {
                    instance = new DoubleCheckSingleton();
                }
            }
        }

        return instance;
    }
}
