package core.basic.chapter09.超级工厂模式;

/**
 * PhoneHuaWei
 *
 * @author he.gang33
 * @CreateDate 2020/12/8
 * @see core.basic.chapter09.超级工厂模式
 * @since R9.0
 */
public class PhoneHuaWei implements Phone {

    @Override
    public String call() {
        return "call somebody by huawei phone.";
    }
}
