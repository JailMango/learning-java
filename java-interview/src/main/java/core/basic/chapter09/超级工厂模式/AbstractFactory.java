package core.basic.chapter09.超级工厂模式;

/**
 * AbstractFactory
 *
 * @author he.gang33
 * @CreateDate 2020/12/8
 * @see core.basic.chapter09.超级工厂模式
 * @since R9.0
 */
public abstract class AbstractFactory {

    public abstract Phone createPhone(String brand);

    public abstract Computer createComputer(String brand);
}
