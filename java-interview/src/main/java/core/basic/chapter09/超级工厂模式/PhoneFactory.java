package core.basic.chapter09.超级工厂模式;

/**
 * PhoneFactory
 *
 * @author jailmango
 * @CreateDate 2020/12/8
 * @see core.basic.chapter09.超级工厂模式
 * @since R9.0
 */
public class PhoneFactory extends AbstractFactory {

    @Override
    public Phone createPhone(String brand) {
        if ("HuaWei".equals(brand)) {
            return new PhoneHuaWei();
        }
        else if ("Apple".equals(brand)) {
            return new PhoneApple();
        }
        else {
            return null;
        }
    }

    @Override
    public Computer createComputer(String brand) {
        return null;
    }
}
