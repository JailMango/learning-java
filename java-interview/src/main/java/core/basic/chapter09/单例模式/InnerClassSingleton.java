package core.basic.chapter09.单例模式;

/**
 * 单例模式 - 内部类
 *
 * @author he.gang33
 * @CreateDate 2020/12/9
 * @see core.basic.chapter09.单例模式
 * @since R9.0
 */
public class InnerClassSingleton {

    private InnerClassSingleton() {

    }

    public static InnerClassSingleton getInstance() {
        return InnerClassSingletonHolder.INSTANCE;
    }

    private static class InnerClassSingletonHolder {

        private static final InnerClassSingleton INSTANCE = new InnerClassSingleton();
    }
}
