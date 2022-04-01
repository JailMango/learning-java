package core.basic.chapter09.中介者模式;

/**
 * Mediator
 *
 * @author jailmango
 * @CreateDate 2020/12/18
 * @see core.basic.chapter09.中介者模式
 * @since R9.0
 */
public abstract class Mediator {

    protected Colleague colleagueTenant;

    protected Colleague colleagueLandlord;

    public Mediator(Colleague colleagueTenant, Colleague colleagueLandlord) {
        this.colleagueTenant = colleagueTenant;
        this.colleagueLandlord = colleagueLandlord;
    }

    public abstract boolean notifyColleagueTenant(String message);

    public abstract boolean notifyColleagueLandlord(String message);
}
