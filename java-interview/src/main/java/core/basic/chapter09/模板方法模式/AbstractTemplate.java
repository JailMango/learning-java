package core.basic.chapter09.模板方法模式;

import lombok.extern.slf4j.Slf4j;

/**
 * AbstractTemplate
 *
 * @author jailmango
 * @CreateDate 2020/12/15
 * @see core.basic.chapter09.模板方法模式
 * @since R9.0
 */
@Slf4j
public abstract class AbstractTemplate {

    public abstract void handleBussiness();

    public void templateMethod() {
        checkNumber();
        queueUp();
        handleBussiness();
        serviceEvaluation();
    }

    public void checkNumber() {
        log.info("check number...");
    }

    public void queueUp() {
        log.info("queue up...");
    }

    public void serviceEvaluation() {
        log.info("bussiness finished, service evaluation....");
    }
}
