package core.basic.chapter09.中介者模式;

/**
 * 中介者模式
 *
 * @author he.gang33
 * @CreateDate 2020/12/18
 * @see core.basic.chapter09.中介者模式
 * @since R9.0
 */
public class 中介者模式 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Colleague colleagueTenant = new ColleagueTenant();
        Colleague colleagueLandlord = new ColleagueLandlord();
        ConcreteMediator concreteMediator = new ConcreteMediator(colleagueTenant, colleagueLandlord);

        boolean result = concreteMediator.notifyColleagueTenant("aaa");
        if (result) {
            concreteMediator.notifyColleagueLandlord("xxx");
        }
        else {
            concreteMediator.notifyColleagueLandlord("yyy");
        }
    }
}
