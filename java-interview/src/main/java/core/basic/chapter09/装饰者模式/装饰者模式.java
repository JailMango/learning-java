package core.basic.chapter09.装饰者模式;

/**
 * 装饰者模式
 *
 * @author he.gang33
 * @CreateDate 2020/12/14
 * @see core.basic.chapter09.装饰者模式
 * @since R9.0
 */
public class 装饰者模式 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Sourceable source = new Source();
        Sourceable obj = new Decorator(source);
        obj.createComputer();
    }
}
