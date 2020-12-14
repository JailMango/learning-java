package core.basic.chapter09.超级工厂模式;

import lombok.extern.slf4j.Slf4j;

/**
 * Case
 *
 * @author he.gang33
 * @CreateDate 2020/12/8
 * @see core.basic.chapter09.超级工厂模式
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
        AbstractFactory phoneFactory = new PhoneFactory();
        Phone phoneHw = phoneFactory.createPhone("HuaWei");
        Phone phoneApple = phoneFactory.createPhone("Apple");

        log.info(phoneHw.call());
        log.info(phoneApple.call());

        AbstractFactory computerFactory = new ComputerFactory();
        Computer computerHw = computerFactory.createComputer("HuaWei");
        Computer computerApple = computerFactory.createComputer("Apple");

        log.info(computerHw.internet());
        log.info(computerApple.internet());
    }
}
