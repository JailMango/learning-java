package core.basic.chapter09.中介者模式;

import lombok.extern.slf4j.Slf4j;

/**
 * ColleagueLandlord
 *
 * @author he.gang33
 * @CreateDate 2020/12/18
 * @see core.basic.chapter09.中介者模式
 * @since R9.0
 */
@Slf4j
public class ColleagueLandlord extends Colleague {

    @Override
    public boolean operation(String message) {
        log.info("landlord receive a message from mediator: {}", message);
        return true;
    }
}
