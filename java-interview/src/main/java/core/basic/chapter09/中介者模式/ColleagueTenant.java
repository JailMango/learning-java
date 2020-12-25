package core.basic.chapter09.中介者模式;

import lombok.extern.slf4j.Slf4j;

/**
 * ColleagueTenant
 *
 * @author he.gang33
 * @CreateDate 2020/12/18
 * @see core.basic.chapter09.中介者模式
 * @since R9.0
 */
@Slf4j
public class ColleagueTenant extends Colleague {

    @Override
    public boolean operation(String message) {
        log.info("tenant receive a message from mediator: {}", message);
        return true;
    }
}
