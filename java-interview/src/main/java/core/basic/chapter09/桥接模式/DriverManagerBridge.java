package core.basic.chapter09.桥接模式;

/**
 * DriverManagerBridge
 *
 * @author he.gang33
 * @CreateDate 2020/12/14
 * @see core.basic.chapter09.桥接模式
 * @since R9.0
 */
public abstract class DriverManagerBridge {

    private Driver driver;

    public void execute() {
        this.driver.executeSQL();
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
