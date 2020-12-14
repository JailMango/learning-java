package core.basic.chapter09.超级工厂模式;

/**
 * ComputerFactory
 *
 * @author he.gang33
 * @CreateDate 2020/12/8
 * @see core.basic.chapter09.超级工厂模式
 * @since R9.0
 */
public class ComputerFactory extends AbstractFactory {

    @Override
    public Phone createPhone(String brand) {
        return null;
    }

    @Override
    public Computer createComputer(String brand) {
        if ("HuaWei".equals(brand)) {
            return new ComputerHuaWei();
        }
        else if ("Apple".equals(brand)) {
            return new ComputerApple();
        }
        else {
            return null;
        }
    }
}
