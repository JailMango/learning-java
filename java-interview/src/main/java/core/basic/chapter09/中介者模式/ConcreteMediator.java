package core.basic.chapter09.中介者模式;

/**
 * ConcreteMediator
 *
 * @author jailmango
 * @CreateDate 2020/12/18
 * @see core.basic.chapter09.中介者模式
 * @since R9.0
 */
public class ConcreteMediator extends Mediator {

    public ConcreteMediator(Colleague colleagueTenant, Colleague colleagueLandlord) {
        super(colleagueTenant, colleagueLandlord);
    }

    @Override
    public boolean notifyColleagueTenant(String message) {
        if (colleagueTenant != null) {
            return colleagueTenant.operation(message);
        }
        return false;
    }

    @Override
    public boolean notifyColleagueLandlord(String message) {
        if (colleagueLandlord != null) {
            colleagueLandlord.operation(message);
        }
        return false;
    }
}
