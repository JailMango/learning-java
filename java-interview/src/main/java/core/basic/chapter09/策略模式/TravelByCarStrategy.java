package core.basic.chapter09.策略模式;

import lombok.extern.slf4j.Slf4j;

/**
 * TravelByCarStrategy
 *
 * @author jailmango
 * @CreateDate 2020/12/15
 * @see core.basic.chapter09.策略模式
 * @since R9.0
 */
@Slf4j
public class TravelByCarStrategy implements TravelStrategy {

    @Override
    public void travelMode() {
        log.info("travel by car...");
    }
}
