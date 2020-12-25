package core.basic.chapter09.桥接模式;

/**
 * 桥接模式
 *
 * @author he.gang33
 * @CreateDate 2020/12/14
 * @see core.basic.chapter09.桥接模式
 * @since R9.0
 */
public class 桥接模式 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        DriverManagerBridge driverManagerBridge = new MyDriverBridge();
        driverManagerBridge.setDriver(new MysqlDriver());
        driverManagerBridge.execute();

        driverManagerBridge.setDriver(new OracleDriver());
        driverManagerBridge.execute();
    }
}
