package core.basic.chapter09.中介者模式;

/**
 * Colleague
 *
 * @author he.gang33
 * @CreateDate 2020/12/18
 * @see core.basic.chapter09.中介者模式
 * @since R9.0
 */
public abstract class Colleague {

    private Mediator mediator;

    public abstract boolean operation(String message);

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
}
