package core.basic.chapter09.观察者模式;

import lombok.extern.slf4j.Slf4j;

/**
 * ConcreteObserver
 *
 * @author he.gang33
 * @CreateDate 2020/12/17
 * @see core.basic.chapter09.观察者模式
 * @since R9.0
 */
@Slf4j
public class ConcreteObserver implements Observer {

    @Override
    public void dataChange(String message) {
        log.info("recevie message [{}]", message);
    }
}
