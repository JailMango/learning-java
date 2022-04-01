package core.basic.chapter09.观察者模式;

/**
 * 观察者模式
 *
 * @author jailmango
 * @CreateDate 2020/12/17
 * @see core.basic.chapter09.观察者模式
 * @since R9.0
 */
public class 观察者模式 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        Observer observer = new ConcreteObserver();
        subject.add(observer);
        subject.notifyObservers("data1");
    }
}
