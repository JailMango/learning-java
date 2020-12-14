package core.basic.chapter09.工厂模式;

import lombok.extern.slf4j.Slf4j;

/**
 * 工厂模式Case
 *
 * @author he.gang33
 * @CreateDate 2020/12/8
 * @see core.basic.chapter09.工厂模式
 * @since R9.0
 */
@Slf4j
public class Case {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        PhoneFactory factory = new PhoneFactory();
        Phone hw = factory.createPhone("HuaWei");
        Phone iphone = factory.createPhone("Apple");

        log.info(hw.brand());
        log.info(iphone.brand());
    }
}
