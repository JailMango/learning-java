package core.basic.chapter09.超级工厂模式;

/**
 * ComputerApple
 *
 * @author he.gang33
 * @CreateDate 2020/12/8
 * @see core.basic.chapter09.超级工厂模式
 * @since R9.0
 */
public class ComputerApple implements Computer {

    @Override
    public String internet() {
        return "surf the internet by apple computer.";
    }
}
