package core.basic.chapter09.桥接模式;

/**
 * MyDriverBridge
 *
 * @author he.gang33
 * @CreateDate 2020/12/14
 * @see core.basic.chapter09.桥接模式
 * @since R9.0
 */
public class MyDriverBridge extends DriverManagerBridge {

    @Override
    public void execute() {
        getDriver().executeSQL();
    }
}
