package core.basic.chapter09.命令模式;

/**
 * ConcreteCommand
 *
 * @author he.gang33
 * @CreateDate 2020/12/17
 * @see core.basic.chapter09.命令模式
 * @since R9.0
 */
public class ConcreteCommand implements Command {

    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void exe(String command) {
        receiver.action(command);
    }
}
