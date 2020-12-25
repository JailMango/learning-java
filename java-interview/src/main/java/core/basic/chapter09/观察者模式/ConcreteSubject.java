package core.basic.chapter09.观察者模式;

import lombok.extern.slf4j.Slf4j;

/**
 * ConcreteSubject
 *
 * @author he.gang33
 * @CreateDate 2020/12/17
 * @see core.basic.chapter09.观察者模式
 * @since R9.0
 */
@Slf4j
public class ConcreteSubject extends Subject {

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            log.info("notify observe [{}] change...", message);
            observer.dataChange(message);
        }
    }
}
