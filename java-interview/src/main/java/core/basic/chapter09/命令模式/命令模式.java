package core.basic.chapter09.命令模式;

/**
 * 命令模式
 *
 * @author he.gang33
 * @CreateDate 2020/12/17
 * @see core.basic.chapter09.命令模式
 * @since R9.0
 */
public class 命令模式 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command command = new ConcreteCommand(receiver);
        Invoker invoker = new Invoker(command);
        invoker.action("haah...");
    }
}
