package core.basic.chapter09.工厂模式;

/**
 * PhoneFactory
 *
 * @author he.gang33
 * @CreateDate 2020/12/8
 * @see core.basic.chapter09.工厂模式
 * @since R9.0
 */
public class PhoneFactory {

    /**
     * Create Phone
     * 
     * @param phoneName String
     * @return Phone
     */
    public Phone createPhone(String phoneName) {
        if ("HuaWei".equals(phoneName)) {
            return new HuaWei();
        }
        else if ("Apple".equals(phoneName)) {
            return new Iphone();
        }
        else {
            return null;
        }
    }
}
