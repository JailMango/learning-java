package core.basic.chapter09.观察者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * Subject
 *
 * @author jailmango
 * @CreateDate 2020/12/17
 * @see core.basic.chapter09.观察者模式
 * @since R9.0
 */
public abstract class Subject {

    protected List<Observer> observers = new ArrayList<>();

    public abstract void notifyObservers(String message);

    public void add(Observer observer) {
        observers.add(observer);
    }

    public void remove(Observer observer) {
        observers.remove(observer);
    }
}
