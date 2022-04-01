package core.basic.chapter09.状态模式;

/**
 * Context
 *
 * @author jailmango
 * @CreateDate 2020/12/18
 * @see core.basic.chapter09.状态模式
 * @since R9.0
 */
public class Context {

    private AbstractState state;

    public Context(AbstractState state) {
        this.state = state;
    }

    public void action() {
        this.state.action(this);
    }

    public AbstractState getState() {
        return state;
    }

    public void setState(AbstractState state) {
        this.state = state;
    }
}
